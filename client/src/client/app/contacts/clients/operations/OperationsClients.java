package client.app.contacts.clients.operations;

import share.app.contacts.clients.Client;
import share.app.contacts.clients.IOperations;
import client.core.operations.Operation;

public class OperationsClients implements IOperations
{
	private static OperationsClients instance = new OperationsClients();

	public static OperationsClients call()
	{
		return OperationsClients.instance;
	}

	@Override
	public Client getClient(Integer clientID)
	{
		Operation<Client> operation = new Operation<Client>(IOperations.GET_CLIENT);

		return operation.run(clientID);
	}

	@Override
	public Client[] getClients()
	{
		Operation<Client[]> operation = new Operation<Client[]>(IOperations.GET_CLIENTS);

		return operation.run();
	}

	@Override
	public Client addClient(Client client)
	{
		Operation<Client> operation = new Operation<Client>(IOperations.ADD_CLIENT);

		return operation.run(client);
	}

	@Override
	public Boolean editClient(Client original, Client newClient)
	{
		Operation<Boolean> operation = new Operation<Boolean>(IOperations.EDIT_CLIENT);

		return operation.run(original, newClient);
	}

	@Override
	public Boolean deleteClient(Client client)
	{
		Operation<Boolean> operation = new Operation<Boolean>(IOperations.DELETE_CLIENT);

		return operation.run(client);
	}
}