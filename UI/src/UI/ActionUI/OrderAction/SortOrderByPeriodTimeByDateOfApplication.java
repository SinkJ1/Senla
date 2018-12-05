package UI.ActionUI.OrderAction;

import java.util.Scanner;

import Enum.OrderState;
import UI.IAction;
import sort.OrderSort;

public class SortOrderByPeriodTimeByDateOfApplication implements IAction {
	OrderSort os = new OrderSort();
	Scanner in = new Scanner(System.in);

	public void execute() {
		System.out.println("Input first date, second date, OrderState(completed, deleted, canceled)");
		System.out.println(os.periodTimeSortDateOfApplication(in.next(), in.next(), OrderState.valueOf(in.next())));
	}
}
