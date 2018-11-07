package administration;

import java.util.Set;
import Enum.OrderState;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
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

	public void findMasterByOrder(int idOrder) {
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder) {
				System.out.println("First Master = " + order.getPlaceid().getMasterid() + ", Two Master = "
						+ order.getPlaceid().getMasterId2());
			}
		}
	}

	public void findOrderByMaster(int idMaster) {
		for (Order order : orderFromFile) {
			if (order.getPlaceid().getMasterid().getId() == idMaster
					|| order.getPlaceid().getMasterId2().getId() == idMaster) {
				System.out.println(order);
			}
		}
	}

	void update(OrderState state, int idOrder) {
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder && OrderState.performed != state) {
				order.setState(state);
				changeStatusPlace(order.getPlaceid().getId());
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
				orderFromFile.add(order);
				servPlac.setStatus(false);
				save();
			}
		}
	}

	public void nearestFreeDate() {
		int days;
		Date nearestDate = null;
		int minDays = 0;
		try {
			for (Order order : orderFromFile) {
				if (order.getPlaceid().getStatus() == true) {
					nearestDate = date;
					long difference = order.getDateOfCompletion().getTime() - date.getTime();
					days = (int) (difference / (24 * 60 * 60 * 1000));
					if (((days >= 0) && (minDays >= days)) || nearestDate == null) {
						nearestDate = order.getDateOfCompletion();
						minDays = days;
						nearestDate = order.getDateOfCompletion();
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println(nearestDate);
	}

	public void countFreePlaceInFuture(Date date) {
		int countFreePlace = 0;
		for (Order order : orderFromFile) {
			if ((date.after(order.getDateOfCompletion()) || date.equals(order.getDateOfCompletion()))
					|| order.getPlaceid().getStatus() == true) {
				countFreePlace += 1;
			}
		}
		System.out.println(countFreePlace);
	}

	public void changeDateCompletionOrder(int idOrder, String dateOfCompletion) {
		try {
			completionDate = format.parse(dateOfCompletion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Order order : orderFromFile) {
			if (order.getId() == idOrder) {
				order.setDateOfCompletion(completionDate);
				save();
			}
		}
	}

	private void changeStatusPlace(int idPlace) {
		for (ServicePlace servPlace : placeFromFile) {
			if (servPlace.getId() == idPlace) {
				servPlace.setStatus(true);
			}
		}
	}

	private void save() {
		Set<ServicePlace> placeFromFile = new HashSet<ServicePlace>(Arrays.asList(placeUtil.readFromFile()));
		Set<Order> orderFromFile = new HashSet<Order>(Arrays.asList(util.readFromFile()));
		ServicePlace[] place = placeFromFile.toArray(new ServicePlace[placeFromFile.size()]);
		Order[] order = orderFromFile.toArray(new Order[orderFromFile.size()]);
		util.writeToFile(order);
		placeUtil.writeToFile(place);
	}
}
