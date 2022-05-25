package entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Entity class {@code Flight}
 *
 * <p> This class provides the entity about flights' basic information.
 * The map of the seat will record the ID and type of the seat.
 * There are 3 type for the seat: first class, business class, economy class.
 * We will consider of the user's authority, that only the staff can
 * check the customers of the flight.
 *
 * @author Chenyang He & Hao Sun
 * @version 1.0
 *
 */
public class Flight extends Plane {
    private int flightId;
    private String time;
    private String fromCity;
    private String toCity;
    private int gateId;
    private String[] foods = {"Standard", "Vegetarian", "Halal", "Light Meal", "Gourmet Menu", "Chef's Special"};
    private ArrayList<Integer> customers = new ArrayList<>();
    ArrayList<Integer> occupiedSeats = new ArrayList<>();

    /**
     * The default constructor of the Flight
     */
    public Flight() {
        super();
    }

    /**
     * The constructor of the Flight
     * @param flightId The ID of the flight
     * @param time The time of the flight
     * @param fromCity The departure
     * @param toCity The destination
     * @param gateId The ID of the gate
     */
    public Flight(String planeID, int flightId, String time, String fromCity, String toCity, int gateId) {
        super(planeID);
        this.flightId = flightId;
        this.time = time;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.gateId = gateId;
    }

    /**
     * Get the ID of the flight
     *
     * @return flightId
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Set the ID of the flight
     *
     * @param flightId the ID of the flight
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * Get the time of the flight
     *
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * Set the time of the flight
     *
     * @param time the time of the flight
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Get the departure of the flight
     *
     * @return fromCity
     */
    public String getFromCity() {
        return fromCity;
    }

    /**
     * Set the departure of the flight
     *
     * @param fromCity the departure of the flight
     */
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    /**
     * Get the destination of the flight
     *
     * @return toCity
     */
    public String getToCity() {
        return toCity;
    }

    /**
     * Set the destination of the flight
     *
     * @param toCity  the destination of the flight
     */
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    /**
     * Get the gate ID of the flight
     *
     * @return gateId
     */
    public int getGateId() {
        return gateId;
    }

    /**
     * Set the gate ID of the flight
     *
     * @param gateId the gate ID of the flight
     */
    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    /**
     * Get the customer information of the flight
     *
     * @return customers
     */
    public ArrayList<Integer> getCustomers() {
        return customers;
    }

    /**
     * Set the customer information of the flight
     *
     * @param customers the customers of the flight
     */
    public void setCustomers(ArrayList<Integer> customers) {
        this.customers = customers;
    }

    /**
     * Get the food information of the flight
     *
     * @return foods
     */
    public String[] getFoods() {
        return foods;
    }

    /**
     * Set the food information of the flight
     *
     * @param foods the food information of the flight
     */
    public void setFoods(String[] foods) {
        this.foods = foods;
    }

    public ArrayList<Integer> getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(ArrayList<Integer> occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", time='" + time + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", gateId=" + gateId +
                ", foods=" + Arrays.toString(foods) +
                ", customers=" + customers +
                ", occupiedSeats=" + occupiedSeats +
                ", planeId=" + planeId +
                '}';
    }
}
