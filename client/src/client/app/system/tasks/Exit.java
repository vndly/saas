package client.app.system.tasks;

import client.app.system.gui.def.GUIExit;
import client.core.gui.OptionTask;

public class Exit extends OptionTask<Void> {
	
	public Exit() {
		super(GUIExit.PATH, TaskType.SINGLE, true);
	}
	
	public void start() {
		if (showConfirm(GUIExit.Literals.ASK_EXIT)) {
			System.exit(0);
		} else {
			close();
		}
	}
}