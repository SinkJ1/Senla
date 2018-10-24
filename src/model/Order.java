package model;

import java.util.Date;

public class Order {
	
	private int id;
	
	private Date dateOfApplication;

	private Date dateOfCompletion;
	
	private Date dateOfPlannedStartOfExecution;

	private int cost;
	
	private String state; 
	

	public Order( int id, Date dateOfApplication,  Date dateOfCompletion, Date dateOfPlannedStartOfExecution, int cost, String state) {
		this.id = id;
		this.dateOfApplication = dateOfApplication;
		this.dateOfCompletion = dateOfCompletion;
		this.dateOfPlannedStartOfExecution = dateOfPlannedStartOfExecution;
		this.cost = cost;
		this.state = state;
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
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		return "order [id=" + id + ", dateOfApplication=" + dateOfApplication + ", dateOfCompletion=" + dateOfCompletion + ", dateOfPlannedStartOfExecution=" + dateOfPlannedStartOfExecution +", cost=" + cost + ", state=" + state + "]";
	}
}
