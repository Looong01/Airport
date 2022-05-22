package gui.customer.dao;

import entity.Flight;
import entity.Order;
import entity.user.Customer;

import java.io.Serializable;

public class CustomerDAO implements Serializable {
	private Customer customer;
	private Order order;
	private Flight flight;
	private int due = 0;
	private String seatClass;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
}
