package UI.ActionUI.OrderAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmOrder;

public class ChangeDateCompletionOrder implements IAction{

	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input OrderId, Completion Date");
		ao.changeDateCompletionOrder(in.nextInt(), in.next());
	}
}
