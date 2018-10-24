package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.Order;
import util.OrderUtil;

public class OrderSort {
		OrderUtil util = new OrderUtil("E:\\Users\\Admin\\eclipse-workspace\\LIST_4\\textFile\\Order.txt");
	
		public  List<Order> dateOfApplication() { 
			List<Order> listorder = toList();
			listorder.sort(Comparator.comparing(Order::getDateOfApplication));
			return listorder;
		}
	
		public  List<Order> dateOfCompletion() { 
			List<Order> listorder = toList();
			listorder.sort(Comparator.comparing(Order::getDateOfCompletion));
			return listorder;
		}
		
		public  List<Order> dateOfPlannedStartOfExecution() { 
			List<Order> listorder = toList();
			listorder.sort(Comparator.comparing(Order::getDateOfPlannedStartOfExecution));
				return listorder;
			}
		
		public  List<Order> cost() { 
			List<Order> listorder = toList();
			listorder.sort(Comparator.comparing(Order::getCost));
				return listorder;
			}

		private  List<Order> toList() { 
			return Arrays.asList(util.readFromFile()); 
		} 
		
}
