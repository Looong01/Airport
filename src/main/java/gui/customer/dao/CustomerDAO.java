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
	private boolean seatSelected = false;
	private boolean foodSelected = false;

	/**
	 * get customer
	 * @return Customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * set customer
	 * @param customer Customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * get order
	 * @return Order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * set order
	 * @param order Order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * get flight
	 * @return Flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * set flight
	 * @param flight Flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * get seat due
	 * @return int seat due
	 */
	public int getSeatDue() {
		return seatDue;
	}

	/**
	 * set seat due
	 * @param seatDue seat due
	 */
	public void setSeatDue(int seatDue) {
		this.seatDue = seatDue;
	}

	/**
	 * get food due
	 * @return int food due
	 */
	public int getFoodDue() {
		return foodDue;
	}

	/**
	 * set food due
	 * @param foodDue food due
	 */
	public void setFoodDue(int foodDue) {
		this.foodDue = foodDue;
	}

	/**
	 * is card login
	 * @return card login
	 */
	public boolean isCardLogin() {
		return cardLogin;
	}

	/**
	 * set card login
	 * @param cardLogin card login
	 */
	public void setCardLogin(boolean cardLogin) {
		this.cardLogin = cardLogin;
	}

	/**
	 * is seat selected
	 * @return seat selected
	 */
	public boolean isSeatSelected() {
		return seatSelected;
	}

	/**
	 * set seat selected
	 * @param seatSelected seat selected
	 */
	public void setSeatSelected(boolean seatSelected) {
		this.seatSelected = seatSelected;
	}

	/**
	 * is food selected
	 * @return boolean food selected
	 */
	public boolean isFoodSelected() {
		return foodSelected;
	}

	/**
	 * set food selected
	 * @param foodSelected food selected
	 */
	public void setFoodSelected(boolean foodSelected) {
		this.foodSelected = foodSelected;
	}

	/**
	 * reset all instance variables
	 */
	public void reset() {
		customer = null;
		order = null;
		flight = null;
		seatDue = 0;
		foodDue = 0;
		cardLogin = true;
		seatSelected = false;
		foodSelected = false;
	}
}