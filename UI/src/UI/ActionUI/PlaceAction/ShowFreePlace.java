package UI.ActionUI.PlaceAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmPlace;

public class ShowFreePlace implements IAction {
	AdmPlace ap = new AdmPlace();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println(ap.freePlace());
	}
}
