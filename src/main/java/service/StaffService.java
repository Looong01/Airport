package service;

/**
 * Service class {@code StaffService}
 *
 * <p> This class provides an interface for methods required for staff side actions.
 * The function of these methods is described in detail in this interface's implement, class StaffServiceImpl
 *
 * @author Zelong Le
 * @author Shuzhou Zhao
 * @version 1.2
 *
 */

public interface StaffService {
    
    /**
     * This method helps to check whether the staff is allowed to log in.
     *
     * @param cardId The card ID of the customer.
     * @param passwd The passwd of the staff to log in.
     * @return Whether the input user ID and password is correct.
     */
    boolean loginByPasswd(String cardId,String passwd);
    
      /**
     * This method helps to check customers' status.
     * 
     * @param flightId The ID of current flight.
     * @return An array whose length is 4 with the type int.
     *         Index 0 represents the number of customer who haven't finished the
     *         check-in.
     *         Index 1 represents the number of customer who have already checked in
     *         but haven't boarded.
     *         Index 2 represents the number of customer who have already finished
     *         boarding.
     *         Index 3 represents the overall number of customer of the current
     *         flight.
     */
    int[] checkFlight(String flightId);

/**
     * This method helps to find the flight ID from the flight list.
     *
     * @return All the flight ID in the flight list.
     */
    String[] getFlightIds();

  /**
    *This method helps to find the gate ID.
    *
    * @param flightId The ID of current flight.
    * @return The gate ID of current flight.
     */
    int getGateId(String flightId);

    /**
    *This method helps to find the FromCity.
    *
    * @param flightId The ID of current flight.
    * @return The FromCity of current flight.
     */
    String getFromCity(String flightId);

    /**
    *This method helps to find the ToCity.
    *
    * @param flightId The ID of current flight.
    * @return The ToCity of current flight.
     */
    String getToCity(String flightId);

    /**
    *This method helps to find the departure time.
    *
    * @param flightId The ID of current flight.
    * @return The departure time of current flight.
     */
    String getTime(String flightId);

    /**
    *This method helps to find the orderId
    *
    * @param userid the user Id.
    * @return The orderId of current user.    
     */
    String[] getOrderId(int userid);

 /**
    *This method helps to find the status
    *
    * @param orderId the orderId.
    * @return The status of current flight.
     */
    String getStatus(String orderId);

    /**
    *This method helps to find the flightId
    *
    * @param flightId the flightId.
    * @return The all userIds of this flight.
     */
    int[] getUserIds(String flightId);

    /**
    *This method helps to find the cardId
    *
    * @param userId the userId.
    * @return The cardId of this user.
     */
    String getCardId(int userId);

    /**
    *This method helps to find the user's name
    *
    * @param userId the userId.
    * @return The name of this user.
     */
    String getName(int userId);
  
    /**
    *This method helps to find flightId from the orderId
    *
    * @param orderId the orderId.
    * @return The flightId of this order.
     */
    String getFlightId(String orderId);

    /**
     * This method is to find all the flightIds
     * 
     * @return flightIds
     */
    String[] getFlightId();

    /**
    * This method is to find all the orderIds
    *
    * @return orderIds
     */
    String[] getOrderId();

    /**
    * This method is to find all the seats
    *
    * @return seats
     */
    String[] getSeat();

    /**
    * This method is to find all the food
    *
    * @return food
     */
    String[] getFood();

    /**
    * This method is to find the total num of orders
    *
    * @return orderNum
     */
    int getOrderNum();
}
