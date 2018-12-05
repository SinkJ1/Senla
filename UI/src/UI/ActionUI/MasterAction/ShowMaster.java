package UI.ActionUI.MasterAction;

import UI.IAction;
import administration.AdmMaster;

public class ShowMaster implements IAction {

	public void execute() {
		AdmMaster am = new AdmMaster();
		System.out.println(am.showMaster());
	}

}
