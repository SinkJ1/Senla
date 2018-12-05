package UI.ActionUI.OrderAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmOrder;

public class CountFreePlaceInFuture implements IAction {

	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input Date In Future");
		ao.countFreePlaceInFuture(in.next());
	}
	
}
