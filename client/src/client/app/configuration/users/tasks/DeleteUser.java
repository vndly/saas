package client.app.configuration.users.tasks;

import share.core.objects.User;
import client.app.configuration.users.gui.def.GUIDeleteUser;
import client.app.configuration.users.operations.OperationsUsers;
import client.core.gui.taks.Activity;

public class DeleteUser extends Activity<Boolean>
{
	private final User user;

	public DeleteUser(User user)
	{
		super(GUIDeleteUser.PATH, Type.SINGLE);

		this.user = user;
	}

	@Override
	public void start()
	{
		if (showConfirmLiteral(getLiteral(GUIDeleteUser.Literals.ASK_DELETE, this.user.name)))
		{
			Boolean response = OperationsUsers.call().deleteUser(this.user);
			close(valid(response));
		}
		else
		{
			close(false);
		}
	}
}