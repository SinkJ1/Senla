package UI.ActionUI.OrderAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmOrder;

public class FindOrderByMaster implements IAction {

	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input MasterId");
		ao.findOrderByMaster(in.nextInt());
	}
	
}
