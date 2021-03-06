package entity;

import java.io.Serializable;

/**
 * Entity class {@code Order}
 *
 * <p> This class provides the entity about orders' basic information.
 * There are two type of the order's status: checkIn, waiting，boarding
 * C: checkIn, User have not checked in
 * W: waiting, User have checked in and waited for the flight
 * B: boarding, User have been on the plane
 *
 * @author Chenyang He
 * @author Hao Sun
 * @version 1.0
 *
 */
public class Order implements Serializable {
    private String orderId;
    private int userId;
    private String status;
    private String flightId;
    private int seatId;
    private String food;
    private int packageGate;
    private int carryOn;
    private int checkIn;

    /**
     * The default constructor of the Config
     */
    public Order(){

    }

    /**
     * The constructor of the Order, be careful to use this.
     * This constructor will always be used to initialize
     * The status will be set "Waiting"
     * The seatId will be set -1 which mean not chosen
     * The food will be set "Not Chosen"
     * @param orderId The ID of the order
     * @param userId ID of customer as user
     * @param flightId The ID of the flight in this order
     * @param packageGate The gate ID of the package
     * @param carryOn The number of the carry on package
     * @param checkIn The number of the check in package
     */
    public Order(String orderId, int userId, String flightId, int packageGate, int carryOn, int checkIn) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = "C";
        this.flightId = flightId;
        this.seatId = -1;
        this.food = "Not Chosen";
        this.packageGate = packageGate;
        this.carryOn = carryOn;
        this.checkIn = checkIn;
    }

    /**
     * Get the ID of the order
     *
     * @return orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Set the ID of the order
     *
     * @param orderId the ID of the order
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the user ID of the order
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user ID of the order
     *
     * @param userId the ID of the order
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the status of the order
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order
     * C: checkIn, User have not checked in
     * W: waiting, User have checked in and waited for the flight
     * B: boarding, User have been on the plane
     *
     * @param status the status of the order
     */
    public void setStatus(String status) {
        if(status.equals("C")||status.equals("W")||status.equals("B")) {
            this.status = status;
        }
        else{
            System.out.println("Not valid!");
        }
    }

    /**
     * Get the flight ID of the order
     *
     * @return flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * Set the flight ID of the order
     *
     * @param flightId the ID of the flight
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * Get the seat ID of the order
     *
     * @return seatId
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * Set the seat ID of the order
     *
     * @param seatId the ID of the seat
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    /**
     * Get the food of the order
     *
     * @return food
     */
    public String getFood() {
        return food;
    }

    /**
     * Set the food of the order
     *
     * @param food the food of the order
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * get package gate
     * @return int
     */
    public int getPackageGate() {
        return packageGate;
    }

    /**
     * set package gate
     * @param packageGate int
     */
    public void setPackageGate(int packageGate) {
        this.packageGate = packageGate;
    }

    /**
     * get carry on number
     * @return int
     */
    public int getCarryOn() {
        return carryOn;
    }

    /**
     * set carry on number
     * @param carryOn int
     */
    public void setCarryOn(int carryOn) {
        this.carryOn = carryOn;
    }

    /**
     * get check-in number
     * @return int
     */
    public int getCheckIn() {
        return checkIn;
    }

    /**
     * set check-in number
     * @param checkIn int
     */
    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * The toString() method for the order
     *
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", flightId=" + flightId +
                ", seatId=" + seatId +
                ", food='" + food + '\'' +
                ", packageGate=" + packageGate +
                ", carryOn=" + carryOn +
                ", checkIn=" + checkIn +
                '}';
    }
}