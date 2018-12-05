package UI.ActionUI.OrderAction;

import UI.IAction;
import administration.AdmOrder;

public class ShowOrder implements IAction {
	
	AdmOrder ao = new AdmOrder();
	
	public void execute() {
		System.out.println(ao.showOrder());
	}
}
