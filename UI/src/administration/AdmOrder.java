package administration;

import java.util.Set;
import Enum.OrderState;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import model.Order;
import model.ServicePlace;
import util.AutoMasterUtil;
import model.AutoMaster;
import util.OrderUtil;
import util.ServicePlaceUtil;

public class AdmOrder {

	OrderUtil util = new OrderUtil("textFile/Order.txt");
	ServicePlaceUtil placeUtil = new ServicePlaceUtil("textFile/place.txt");
	AutoMasterUtil masterUtil = new AutoMasterUtil("textFile/AutoMaster.txt");
	Set<AutoMaster> masterFromFile = new HashSet<AutoMaster>(Arrays.asList(masterUtil.readFromFile()));
	Set<ServicePlace> placeFromFile = new HashSet<ServicePlace>(Arrays.asList(placeUtil.readFromFile()));
	Set<Order> orderFromFile = new HashSet<Order>(Arrays.asList(util.readFromFile()));
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	Date applicationDate = null;
	Date completionDate = null;
	Date plannedStartOfExecutionDate = null;
	Date date = new Date();
	Set<Order> orderPerformed = new HashSet<Order>();
	Set<Order> orderQueue = new HashSet<Order>();
	
	public void findMasterByOrder(int idOrder) {
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder) {
				System.out.println("First Master = " + order.getPlaceid().getMasterid() + ", Two Master = "
						+ order.getPlaceid().getMasterId2());
			}
		}
	}
	
	public List<Order> showOrder(){
		return Arrays.asList(util.readFromFile());
	}

	public void findOrderByMaster(int idMaster) {
		for (Order order : orderFromFile) {
			if (order.getPlaceid().getMasterid().getId() == idMaster
					|| order.getPlaceid().getMasterId2().getId() == idMaster) {
				System.out.println(order);
			}
		}
	}

	public void updateStateOrder(OrderState state, int idOrder) {
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder && OrderState.performed != state) {
				order.setState(state);
				changeStatusPlace(order.getPlaceid().getId(), true);
				orderFromFile.add(order);
				save();
			}
		}
	}

	public void addOrder(int idOrder, int cost, int idServPlace, String dateOfApplication, String dateOfCompletion,
			String dateOfPlannedStartOfExecution) {
		try {
			applicationDate = format.parse(dateOfApplication);
			completionDate = format.parse(dateOfCompletion);
			plannedStartOfExecutionDate = format.parse(dateOfPlannedStartOfExecution);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (ServicePlace servPlac : placeFromFile) {
			if (servPlac.getId() == idServPlace && servPlac.getStatus() != false) {
				Order order = new Order(idOrder, cost, servPlac, OrderState.performed, applicationDate, completionDate,
						plannedStartOfExecutionDate);

				changeStatusPlace(idOrder, false);
				orderFromFile.add(order);
			} else {
				Order order = new Order(idOrder, cost, servPlac, OrderState.inQueue, applicationDate, completionDate,
						plannedStartOfExecutionDate);

				orderFromFile.add(order);
			}
			save();
		}
	}

	/*public Date nearestFreeDate() {
		
			for (ServicePlace place : placeFromFile) {
				if (place.getStatus() == true) {
					return new Date();
				}	
			}
		
		for (Order order : orderFromFile) {
			if(order.getState() == OrderState.performed) {
				orderPerformed.add(order);
			}
			
			if(order.getState() == OrderState.inQueue) {
				orderQueue.add(order);
			}
		}
		
			for(Order orderPerf : orderPerformed) {
				for(Order orderQue : orderQueue) {
					if (orderPerf.getPlaceid().getId() == orderQue.getPlaceid().getId() && orderQue.getDateOfCompletion().after(orderPerf.getDateOfCompletion())) {
						orderPerf.setDateOfCompletion(orderQue.getDateOfCompletion());
					}
				}
		}
			return minDate(orderPerformed);
	}*/
	
	

	public int countFreePlaceInFuture(String date) {
		int countFreePlace = 0;
		try {
			applicationDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (Order order : orderFromFile) {
			if(order.getState() == OrderState.performed) {
				orderPerformed.add(order);
			}
			
			if(order.getState() == OrderState.inQueue) {
				orderQueue.add(order);
			}
		}
		
		for(Order orderPerf : orderPerformed) {
			for(Order orderQue : orderQueue) {
				if ((orderPerf.getPlaceid().getId() == orderQue.getPlaceid().getId() &&
						(applicationDate.before(orderQue.getDateOfPlannedStartOfExecution())) || 
						(orderPerf.getPlaceid().getId() != orderQue.getPlaceid().getId() && applicationDate.after(orderPerf.getDateOfCompletion())))) {
					System.out.println(orderPerf);
					countFreePlace += 1;
				}
			}
		}

		return countFreePlace;
	}

	public void changeDateCompletionOrder(int idOrder, String dateOfCompletion) {
		long difference =0l;
		int placeId=0;
		try {
			 completionDate = format.parse(dateOfCompletion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder) {
				placeId=order.getPlaceid().getId();
				difference =  completionDate.getTime() - order.getDateOfCompletion().getTime();
				order.setDateOfCompletion(completionDate);
				save();
			}
			if (order.getId() != idOrder && order.getPlaceid().getId() == placeId) {
				order.setDateOfCompletion(new Date(difference + order.getDateOfCompletion().getTime()));
				save();
			}
		}
	}
	
	
	private Date minDate(Set<Order> readOrder) {
		Date nearestDate = null;
		Long minDays = 0l;
		for (Order order : readOrder) {
			long difference = order.getDateOfCompletion().getTime() - new Date().getTime();
			if ((difference >= 0) && (minDays >= difference) || nearestDate == null) {
				minDays = difference;
				nearestDate = order.getDateOfCompletion();
			}
		}
		return nearestDate;
	}
	
	private void changeStatusPlace(int idPlace, boolean state) {
		for (ServicePlace servPlace : placeFromFile) {
			if (servPlace.getId() == idPlace) {
				servPlace.setStatus(state);
				save();
			}
		}
	}

	private void save() {
		ServicePlace[] place = placeFromFile.toArray(new ServicePlace[placeFromFile.size()]);
		Order[] order = orderFromFile.toArray(new Order[orderFromFile.size()]);
		util.writeToFile(order);
		placeUtil.writeToFile(place);
	}
}
