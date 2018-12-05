package UI.ActionUI.PlaceAction;

import UI.IAction;
import administration.AdmPlace;

public class ShowPlace implements IAction{
	
	AdmPlace am = new AdmPlace();
	
	public void execute() {
		System.out.println(am.showPlace());
	}
}
