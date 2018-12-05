package model;

import Enum.OrderState;
import java.util.Date;

public class Order {

	private int id;

	private Date dateOfApplication;

	private Date dateOfCompletion;

	private Date dateOfPlannedStartOfExecution;

	private OrderState state;

	private int cost;

	private ServicePlace placeid;

	public Order() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Order(int id, int cost, ServicePlace placeid, OrderState state, Date dateOfApplication,
			Date dateOfCompletion, Date dateOfPlannedStartOfExecution) {
		this.id = id;
		this.cost = cost;
		this.placeid = placeid;
		this.state = state;
		this.dateOfApplication = dateOfApplication;
		this.dateOfCompletion = dateOfCompletion;
		this.dateOfPlannedStartOfExecution = dateOfPlannedStartOfExecution;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public ServicePlace getPlaceid() {
		return placeid;
	}

	public void setPlaceid(ServicePlace placeid) {
		this.placeid = placeid;
	}

	public Date getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public Date getDateOfCompletion() {
		return dateOfCompletion;
	}

	public void setDateOfCompletion(Date dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public Date getDateOfPlannedStartOfExecution() {
		return dateOfPlannedStartOfExecution;
	}

	public void setDateOfPlannedStartOfExecution(Date dateOfPlannedStartOfExecution) {
		this.dateOfPlannedStartOfExecution = dateOfPlannedStartOfExecution;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderState getState() {
		return state;
	}

	public String toString() {
		return "order [id=" + id + ", cost=" + cost + ", placeId=" + placeid + ", state = " + state
				+ ", dateOfApplication = " + dateOfApplication + ", dateOfCompletion = " + dateOfCompletion
				+ ", dateOfPlannedStartOfExecution = " + dateOfPlannedStartOfExecution + "]";
	}
}
