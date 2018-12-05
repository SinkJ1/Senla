package UI.ActionUI.OrderAction;

import UI.IAction;
import sort.OrderSort;

public class SortOrderByDateOfCompletion implements IAction{

	OrderSort os = new OrderSort();
	
	public void execute() {
		System.out.println(os.currentOrderSortdateOfCompletion());
	}
}
