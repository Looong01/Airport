package service.impl;

import entity.Flight;
import entity.Order;
import entity.user.*;
import service.StaffService;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service class {@code StaffServiceImpl}
 *
 * <p>
 * This class provides implements for methods required for staff side actions.
 *
 * @author Zelong Le
 * @author Shuzhou Zhao
 * @version 1.2
 *
 */

public class StaffServiceImpl implements StaffService {

    private final JSONController jsonC = new JSONController("src/main/resources/json/Customer.json");
    private final JSONController jsonS = new JSONController("src/main/resources/json/Staff.json");
    private final JSONController jsonO = new JSONController("src/main/resources/json/Order.json");
    private final JSONController jsonF = new JSONController("src/main/resources/json/Flight.json");

    /**
     * This method helps to check whether the staff is allowed to log in.
     *
     * @param cardId The card ID of the customer.
     * @param passwd The passwd of the staff to log in.
     * @return Whether the input user ID and password is correct.
     */
    @Override
    public boolean loginByPasswd(String cardId, String passwd) {
        List<Staff> staffList = jsonS.readArray(Staff.class);
        for (Staff staff : staffList) {
            if (staff.getCardId().equals(cardId) && staff.getPasswd().equals(passwd)) {
                return true;
            }
        }
        return false;

    }

    
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
    @Override
    public int[] checkFlight(String flightId) {
        int a = 0;
        int b = 0;
        int c = 0;
        int all = 0;
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (Objects.equals(order.getFlightId(), flightId)) {
                switch (order.getStatus()) {
                    case "C":
                        a++;
                        all++;
                        break;
                    case "W":
                        b++;
                        all++;
                        break;
                    case "B":
                        c++;
                        all++;
                        break;
                }
            }
        }
        return new int[] { a, b, c, all };
    }
    /**
     * This method helps to find the flight ID from the flight list.
     *
     * @return All the flight ID in the flight list.
     */
    @Override
    public String[] getFlightIds() {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        String[] flightIds = new String[flightList.size()];
        for (int i = 0; i < flightList.size(); i++) {
            flightIds[i] = flightList.get(i).getFlightId();
        }
        return flightIds;
    }

    /**
    *This method helps to find the gate ID.
    *
    * @param flightId The ID of current flight.
    * @return The gate ID of current flight.
     */
    @Override
    public int getGateId(String flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (Objects.equals(flight.getFlightId(), flightId)) {
                return flight.getGateId();
            }
        }
        return -1;
    }

    /**
    *This method helps to find the FromCity.
    *
    * @param flightId The ID of current flight.
    * @return The FromCity of current flight.
     */
    @Override
    public String getFromCity(String flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (Objects.equals(flight.getFlightId(), flightId)) {
                return flight.getFromCity();
            }
        }
        return null;
    }

    /**
    *This method helps to find the ToCity.
    *
    * @param flightId The ID of current flight.
    * @return The ToCity of current flight.
     */
    @Override
    public String getToCity(String flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (Objects.equals(flight.getFlightId(), flightId)) {
                return flight.getToCity();
            }
        }
        return null;
    }

    /**
    *This method helps to find the departure time.
    *
    * @param flightId The ID of current flight.
    * @return The departure time of current flight.
     */
    @Override
    public String getTime(String flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (Objects.equals(flight.getFlightId(), flightId)) {
                return flight.getTime();
            }
        }
        return null;
    }
    /**
    *This method helps to find the orderId
    *
    * @param userid the user Id.
    * @return The orderId of current flight.    
     */
    @Override
    public String[] getOrderId(int userid) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        List<String> orderIdList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getUserId() == userid) {
                orderIdList.addAll(customer.getOrders());
            }
        }
        String[] orderIds = new String[orderIdList.size()];
        for (int i = 0; i < orderIdList.size(); i++) {
            orderIds[i] = orderIdList.get(i);
        }
        return orderIds;
    }


    /**
    *This method helps to find the status
    *
    * @param orderId the orderId.
    * @return The status of current flight.
     */
    @Override
    public String getStatus(String orderId) {
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId))
                return order.getStatus();
        }
        return null;
    }
 
    /**
    *This method helps to find the flightId
    *
    * @param flightId the flightId.
    * @return The all userIds of this flight.
     */
    @Override
    public int[] getUserIds(String flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        List<Integer> customerIdList = new ArrayList<>();
        for (Flight flight : flightList) {
            if (Objects.equals(flight.getFlightId(), flightId)) {
                customerIdList = flight.getCustomers();
            }
        }
        int[] userIds = new int[customerIdList.size()];
        for (int i = 0; i < customerIdList.size(); i++) {
            userIds[i] = customerIdList.get(i);
        }
        return userIds;
    }

    /**
    *This method helps to find the cardId
    *
    * @param userId the userId.
    * @return The cardId of this user.
     */
    @Override
    public String getCardId(int userId) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return customer.getCardId();
            }
        }
        return null;
    }

    /**
    *This method helps to find the user's name
    *
    * @param userId the userId.
    * @return The name of this user.
     */
    @Override
    public String getName(int userId) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return customer.getName();
            }
        }
        return null;
    }

    /**
    *This method helps to find flightId from the orderId
    *
    * @param orderId the orderId.
    * @return The flightId of this order.
     */
    @Override
    public String getFlightId(String orderId) {
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                return order.getFlightId();
            }
        }
        return null;
    }

    /**
     * This method is to find all the flightIds
     * 
     * @return flightIds
     */
    @Override
    public String[] getFlightId() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<String> flightIdList = new ArrayList<>();
        for (Order order : orderList) {
            flightIdList.add(order.getFlightId());
        }
        String[] flightIds = new String[flightIdList.size()];
        for (int i = 0; i < flightIdList.size(); i++) {
            flightIds[i] = String.valueOf(flightIdList.get(i));
        }
        return flightIds;
    }

    /**
    * This method is to find all the orderIds
    *
    * @return orderIds
     */
    @Override
    public String[] getOrderId() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<String> orderIdList = new ArrayList<>();
        for (Order order : orderList) {
            orderIdList.add(order.getOrderId());
        }
        String[] orderIds = new String[orderIdList.size()];
        for (int i = 0; i < orderIdList.size(); i++) {
            orderIds[i] = orderIdList.get(i);
        }
        return orderIds;
    }

    /**
    * This method is to find all the seats
    *
    * @return seats
     */
    @Override
    public String[] getSeat() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<Integer> seatList = new ArrayList<>();
        for (Order order : orderList) {
            seatList.add(order.getSeatId());
        }
        String[] seats = new String[seatList.size()];
        for (int i = 0; i < seatList.size(); i++) {
            if (seatList.get(i) == -1) {
                seats[i] = "Not chosen";
            } else {
                seats[i] = String.valueOf(seatList.get(i));
            }
        }
        return seats;
    }

    /**
    * This method is to find all the food
    *
    * @return food
     */
    @Override
    public String[] getFood() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<String> foodList = new ArrayList<>();
        for (Order order : orderList) {
            foodList.add(order.getFood());
        }
        String[] foods = new String[foodList.size()];
        for (int i = 0; i < foodList.size(); i++) {
            foods[i] = foodList.get(i);
        }
        return foods;
    }

    /**
    * This method is to find the total num of orders
    *
    * @return orderNum
     */
    @Override
    public int getOrderNum() {
        List<Order> orderList = jsonO.readArray(Order.class);
        return orderList.size();
    }
}
