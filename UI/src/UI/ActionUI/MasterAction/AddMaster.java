package UI.ActionUI.MasterAction;

import java.util.Scanner;

import UI.IAction;
import administration.AdmMaster;
import javafx.scene.AmbientLight;

public class AddMaster implements IAction {

	Scanner in = new Scanner(System.in);
	AdmMaster am = new AdmMaster();
	
	public void execute() {
		System.out.println("Enter : masterId, masterName, masterAge, masterAddress");
		am.add(in.nextInt(), in.next(), in.nextInt(), in.next());
	}
}
