package UI.ActionUI.OrderAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmOrder;

public class AddOrder implements IAction{
	
	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input order: id, cost, id ServicePlace, date Of Application, date Of Completion, date Of Planned Start Of Execution");
		ao.addOrder(in.nextInt(), in.nextInt(), in.nextInt(), in.next(), in.next(), in.next());
	}
	
}
