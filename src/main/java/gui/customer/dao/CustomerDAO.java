package gui.customer.dao;

import entity.Flight;
import entity.Order;
import entity.user.Customer;

import java.io.Serializable;

/**
 * GUI storage for temporary changes by user
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class CustomerDAO implements Serializable {
	private Customer customer;
	private Order order;
	private Flight flight;
	private int due = 0;
	private boolean cardLogin = true;

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

	public boolean isCardLogin() {
		return cardLogin;
	}

	public void setCardLogin(boolean cardLogin) {
		this.cardLogin = cardLogin;
	}

	public void reset() {
		customer = null;
		order = null;
		flight = null;
		due = 0;
		cardLogin = true;
	}
}
