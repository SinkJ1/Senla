package UI.ActionUI.MasterAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmOrder;

public class FindMasterByOrder implements IAction{
	
	AdmOrder ao = new AdmOrder();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input OrderId");
		ao.findMasterByOrder(in.nextInt());
	}
	
}
