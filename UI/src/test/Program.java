package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Enum.OrderState;
import administration.AdmMaster;
import administration.AdmOrder;
import administration.AdmPlace;
import model.Order;
import sort.MasterSort;
import sort.OrderSort;
import util.OrderUtil;

public class Program {

	public static void main(String[] args) {
		
		OrderUtil util = new OrderUtil("textFile/Order.txt");
		Scanner in = new Scanner(System.in);
		/*int id = in.nextInt();
		int cost = in.nextInt();*/
	//	AdmMaster admMaster = new AdmMaster();
	//	admMaster.deleteMaster(6);
		//admMaster.add(id, "Vanja", 15, "Grodno");
		
	//	AdmOrder admOrder = new AdmOrder();
	//	admOrder.addOrder(id, cost, 3, "22.10.2018", "23.12.2018", "23.12.2018");
	//	admOrder.changeDateCompletionOrder(2, "24.01.2019");
	//	admOrder.countFreePlaceInFuture("23.12.2018");
	//	admOrder.findMasterByOrder(2);
	//	admOrder.findOrderByMaster(3);
		//System.out.println(admOrder.countFreePlaceInFuture("30.12.2018"));
	//	System.out.println(admOrder.countFreePlaceInFuture("23.12.2018"));
	//	admOrder.updateStateOrder(OrderState.completed, 3);
		
		AdmPlace admPlace = new AdmPlace();
		admPlace.addPlace(5, 4, 5);
		admPlace.freePlace();
		/*
		
		MasterSort masterSort = new MasterSort();
		masterSort.getSortByName();
		
		OrderSort orderSort = new OrderSort();
		List<Order> listorder = new ArrayList<Order>(Arrays.asList(util.readFromFile()));
		orderSort.cost(listorder);
		orderSort.currentOrderSortCost();
		orderSort.currentOrderSortdateOfApplication();
		orderSort.currentOrderSortdateOfCompletion();
		orderSort.dateOfApplication(listorder);
		orderSort.dateOfCompletion(listorder);
		orderSort.dateOfPlannedStartOfExecution(listorder);
		orderSort.periodTimeSortCost("", "", OrderState.canceled);
		orderSort.periodTimeSortDateOfApplication("", "", OrderState.canceled);
		orderSort.periodTimeSortDateOfCompletion("", "", OrderState.canceled);*/
	}
}