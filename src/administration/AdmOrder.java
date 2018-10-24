package administration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.AutoMaster;
import model.Order;
import util.OrderUtil;

public class AdmOrder {
		OrderUtil util = new OrderUtil("E:\\Users\\Admin\\eclipse-workspace\\LIST_4\\textFile\\Order.txt");
		List<Order> masterfromfile = new ArrayList<Order>(Arrays.asList(util.readFromFile()));
		
		public void add() { // adding order
			Order uneversalorder = new Order("required data");
			masterfromfile.add(uneversalorder);	
			save();
		}
		public void deleteorder() {	//delete order id = 1 
			try {
				for (Order order : masterfromfile) {
					if (order.getId() == 1 ) {
						masterfromfile.remove(order);
					}
					save();
				}
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
		
		public void changeDateOfApplication() {		//change date order  id = 3
			for (Order order : masterfromfile) {
					if (order.getId() == 3 ) {
						order.setDateOfApplication(" "); // new Date
					}
					save();
				}
		}
		public void changeStateOrder() {		//change state order  id = 3
			for (Order order : masterfromfile) {
					if (order.getId() == 3 ) {
						order.setState("Complete"); 
					}
					save();
				}
		}
		
		public void save() { // saving changes to file 
			Order[] order = masterfromfile.toArray(new Order[masterfromfile.size()]);
			util.writeToFile(order);
		}
}
