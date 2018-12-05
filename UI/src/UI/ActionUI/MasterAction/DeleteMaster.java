package UI.ActionUI.MasterAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmMaster;

public class DeleteMaster implements IAction {
	
	Scanner in = new Scanner(System.in);
	AdmMaster am = new AdmMaster();

	public void execute() {
		System.out.println("Enter masterId that remove");
		am.deleteMaster(in.nextInt());
	}
}
