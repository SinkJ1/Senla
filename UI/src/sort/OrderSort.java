package sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import Enum.OrderState;
import model.Order;
import util.OrderUtil;

public class OrderSort {
	OrderUtil util = new OrderUtil("textFile/Order.txt");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	Date dateOne = null;
	Date dateTwo = null;
	
	public List<Order> currentDateOfPlannedStartOfExecution() {
		return dateOfPlannedStartOfExecution(currentOrder(writeToList()));
	}

	public List<Order> periodTimeSortDateOfApplication(String firsDate, String twoDate, OrderState state) {
		return dateOfApplication(orderFor¿PeriodOfTime(writeToList(), firsDate, twoDate, state));
	}

	public List<Order> periodTimeSortDateOfCompletion(String firsDate, String twoDate, OrderState state) {
		return dateOfCompletion(orderFor¿PeriodOfTime(writeToList(), firsDate, twoDate, state));
	}

	public List<Order> periodTimeSortCost(String firsDate, String twoDate, OrderState state) {
		return cost(orderFor¿PeriodOfTime(writeToList(), firsDate, twoDate, state));
	}

	public List<Order> currentOrderSortdateOfApplication() {
		return dateOfApplication(currentOrder(writeToList()));
	}

	public List<Order> currentOrderSortdateOfCompletion() {
		return dateOfCompletion(currentOrder(writeToList()));
	}

	public List<Order> currentOrderSortCost() {
		return cost(currentOrder(writeToList()));
	}

	private List<Order> currentOrder(List<Order> listInfo) {
		List<Order> listorder = new ArrayList<Order>();
		for (Order order : listInfo) {
			if (order.getState() == OrderState.performed) {
				listorder.add(order);
			}
		}
		return listorder;
	}

	private List<Order> orderFor¿PeriodOfTime(List<Order> listInfo, String firstDate, String twoDate,
			OrderState state) {
		List<Order> listorder = new ArrayList<Order>();
		try {
			dateOne = format.parse(firstDate);
			dateTwo = format.parse(twoDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Order order : listInfo) {
			if (order.getDateOfCompletion().after(dateOne) && order.getDateOfCompletion().before(dateTwo)
					&& order.getState() == state) {
				listorder.add(order);
			}
		}
		return listorder;
	}

	private List<Order> dateOfApplication(List<Order> listorder) {
		listorder.sort(Comparator.comparing(Order::getDateOfApplication));
		return listorder;
	}

	private List<Order> dateOfCompletion(List<Order> listorder) {
		listorder.sort(Comparator.comparing(Order::getDateOfCompletion));
		return listorder;
	}

	private List<Order> dateOfPlannedStartOfExecution(List<Order> listorder) {
		listorder.sort(Comparator.comparing(Order::getDateOfPlannedStartOfExecution));
		return listorder;
	}

	private List<Order> cost(List<Order> listorder) {
		listorder.sort(Comparator.comparing(Order::getCost));
		return listorder;
	}

	private List<Order> writeToList() {
		return Arrays.asList(util.readFromFile());
	}
}
