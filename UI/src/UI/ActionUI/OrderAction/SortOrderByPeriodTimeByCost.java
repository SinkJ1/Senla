package UI.ActionUI.OrderAction;

import java.util.Scanner;

import Enum.OrderState;
import UI.IAction;
import sort.OrderSort;

public class SortOrderByPeriodTimeByCost implements IAction {

	OrderSort os = new OrderSort();
	Scanner in = new Scanner(System.in);
	
	public void execute() {
		System.out.println("Input first date, second date, OrderState(completed, deleted, canceled)");
		System.out.println(os.periodTimeSortCost(in.next(), in.next(), OrderState.valueOf(in.next())));
	}
	
}
