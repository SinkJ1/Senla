package UI.ActionUI.OrderAction;

import UI.IAction;
import sort.OrderSort;

public class SortOrderByDateOfApplication implements IAction{

	OrderSort os = new OrderSort();
	
	public void execute() {
		System.out.println(os.currentOrderSortdateOfApplication());
	}
	
}
