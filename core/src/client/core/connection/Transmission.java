package client.core.connection;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import share.core.AppError;
import share.core.Constants;
import share.core.Crypt;
import share.core.Encoding;
import share.core.Resource;
import share.core.connection.Parameters;
import share.core.resources.ResourceUtils;
import client.core.Debug;
import client.core.gui.Message;

public class Transmission
{
	private static Socket socket = null;
	
	public static void configure(String ip, int port)
	{
		try
		{
			Transmission.socket = new Socket(ip, port);
			Debug.setInfo("SERVER: " + ip + ":" + port);
		}
		catch (Exception e)
		{
			AppError.setError(e);
		}
	}

	public static String send(Parameters data)
	{
		String result = "";

		try
		{
			KeyPair keys = Crypt.createKeys();
			PrivateKey privateKey = keys.getPrivate();
			PublicKey publicKey = keys.getPublic();

			data.setKey(publicKey.getEncoded());

			byte[] serverKey = Encoding.base64DecodeByte(Resource.load(Constants.PUBLIC_KEY_PATH));

			byte[] parameters = Crypt.encrypt(data.getData(), serverKey);
			
			// -----------------

			InputStream inputStream = Transmission.socket.getInputStream();
			OutputStream outputStream = Transmission.socket.getOutputStream();

			// -----------------
			
			outputStream.write(parameters);
			outputStream.flush();

			// -----------------
			
			byte[] response = ResourceUtils.readInputStream(inputStream);
			result = Crypt.decrypt(response, privateKey.getEncoded());
		}
		catch (Exception e)
		{
			Message.communicationError();
			Debug.setError(e);
		}

		return result;
	}
}