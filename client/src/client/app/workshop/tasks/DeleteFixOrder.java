package client.app.workshop.tasks;

import share.app.workshop.FixOrder;
import client.app.workshop.gui.def.GUIDeleteFixOrder;
import client.app.workshop.operations.OperationsWorkshop;
import client.core.gui.taks.Activity;

public class DeleteFixOrder extends Activity<Boolean>
{
	private final FixOrder fixOrder;
	
	public DeleteFixOrder(FixOrder fixOrder)
	{
		super(GUIDeleteFixOrder.PATH, Type.SINGLE);
		
		this.fixOrder = fixOrder;
	}
	
	@Override
	public void start()
	{
		if (showConfirmLiteral(getLiteral(GUIDeleteFixOrder.Literals.ASK_DELETE, this.fixOrder.clientName)))
		{
			Boolean response = OperationsWorkshop.call().deleteFixOrder(this.fixOrder);
			close(valid(response));
		}
		else
		{
			close(false);
		}
	}
}