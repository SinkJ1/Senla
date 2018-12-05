package UI.ActionUI.OrderAction;

import java.util.Scanner;

import Enum.OrderState;
import UI.IAction;
import administration.AdmOrder;

public class UpdateStateOrder implements IAction{

	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input new State(completed or canceled or deleted or inQueue or performed), OrderID");
		ao.updateStateOrder(OrderState.valueOf(in.next()), in.nextInt());
	}
}
