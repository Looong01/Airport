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
	private int seatDue = 0;
	private int foodDue = 0;
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

	public int getSeatDue() {
		return seatDue;
	}

	public void setSeatDue(int seatDue) {
		this.seatDue = seatDue;
	}

	public int getFoodDue() {
		return foodDue;
	}

	public void setFoodDue(int foodDue) {
		this.foodDue = foodDue;
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
		seatDue = 0;
		foodDue = 0;
		cardLogin = true;
	}
}
