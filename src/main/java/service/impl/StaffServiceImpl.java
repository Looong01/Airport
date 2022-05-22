package service.impl;

import entity.Flight;
import entity.Order;
import entity.user.*;
import service.StaffService;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class {@code StaffServiceImpl}
 *
 * <p>
 * This class provides implements for methods required for staff side actions.
 *
 * @author Loong Lee & Shuzhou Zhao
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
     * This method helps to check whether the user is the customer of current
     * flight.
     *
     * @param cardId   The card ID of the customer.
     * @param flightId The ID of current flight.
     * @return Whether the user is the customer of current flight.
     */
    @Override
    public boolean checkUser(String cardId, int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        Flight currentFlight = null;
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                currentFlight = flight;
            }
        }
        assert currentFlight != null;
        // TODO: 2022/3/27 要修改
        return false;
    }

    // 遍历fightid
    public int[] getFlightIds() {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        int[] flightIds = new int[flightList.size()];
        for (int i = 0; i < flightList.size(); i++) {
            flightIds[i] = flightList.get(i).getFlightId();
        }
        return flightIds;
    }

    // 查找flightid所对应的gateid
    public int getGateId(int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                return flight.getGateId();
            }
        }
        return -1;
    }

    // 查找flightid所对应的fromCity
    public String getFromCity(int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                return flight.getFromCity();
            }
        }
        return null;
    }

    // 查找flightid所对应的toCity
    public String getToCity(int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                return flight.getToCity();
            }
        }
        return null;
    }

    // 查找flightid所对应的time
    public String getTime(int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                return flight.getTime();
            }
        }
        return null;
    }

    // 查找flightId所对应的orderId
    public int[] getOrderIds(int flightId) {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<Integer> orderIdList = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getFlightId() == flightId) {
                orderIdList.add(order.getOrderId());
            }
        }
        int[] orderIds = new int[orderIdList.size()];
        for (int i = 0; i < orderIdList.size(); i++) {
            orderIds[i] = orderIdList.get(i);
        }
        return orderIds;
    }

    // 从jsonC中查找userid所对应的所有orderId
    public int[] getOrderId(int userid) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        List<Integer> orderIdList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getUserId() == userid) {
                orderIdList.addAll(customer.getOrder());
            }
        }
        int[] orderIds = new int[orderIdList.size()];
        for (int i = 0; i < orderIdList.size(); i++) {
            orderIds[i] = orderIdList.get(i);
        }
        return orderIds;
    }


    // 从jsonO中查找orderId所对应的states
    public String getStatus(int orderId) {
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                return order.getStatus();
            }
        }
        return null;
    }
    // 从jsonF中查找flightId所对应的customers
    public int[] getuserIds(int flightId) {
        List<Flight> flightList = jsonF.readArray(Flight.class);
        List<Integer> customerIdList = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getFlightId() == flightId) {
                customerIdList = flight.getCustomers();
            }
        }
        int[] userIds = new int[customerIdList.size()];
        for (int i = 0; i < customerIdList.size(); i++) {
            userIds[i] = customerIdList.get(i);
        }
        return userIds;
    }

    // 从jsonC中查找userId所对应的cardId
    public String getCardId(int userId) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return customer.getCardId();
            }
        }
        return null;
    }

    // 从jsonC中查找userId所对应的name
    public String getName(int userId) {
        List<Customer> customerList = jsonC.readArray(Customer.class);
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return customer.getName();
            }
        }
        return null;
    }
    // 从jsonO中查找orderId所对应的flightId
    public int getFlightId(int orderId) {
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                return order.getFlightId();
            }
        }
        return -1;
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
    public int[] checkFlight(int flightId) {
        int a = 0;
        int b = 0;
        int c = 0;
        int all = 0;
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getFlightId() == flightId) {
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
     * This method is to check the food which customers choose.
     * We only need to return a list of food.
     * If counter is needed, it will be implemented in the controller class.
     * 
     * @param flightId The ID of current flight.
     * @return foodList: An arraylist contains the food selected by each customer.
     */
    @Override
    public ArrayList<String> checkOrder(int flightId) {
        ArrayList<String> foodList = new ArrayList<>();
        List<Order> orderList = jsonO.readArray(Order.class);
        for (Order order : orderList) {
            if (order.getFlightId() == flightId) {
                String food = order.getFood();
                int orderid = order.getOrderId();
                int seatid = order.getSeatId();
                if (seatid == -1) {
                    String seat = "Not chosen";
                    foodList.add("\n\n\tThe Order ID: " + orderid + "\n\t\t—— The  Food: " + food
                            + "\n\t\t—— The Seat: " + seat);
                } else {
                    foodList.add("\n\n\tThe Order ID: " + orderid + "\n\t\t—— The  Food: " + food
                            + "\n\t\t—— The Seat: " + seatid);
                }
            }
        }
        return foodList;
    }

    // 返回所有order的flightid到string数组中
    public String[] getFlightId() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<Integer> flightIdList = new ArrayList<>();
        for (Order order : orderList) {
            flightIdList.add(order.getFlightId());
        }
        String[] flightIds = new String[flightIdList.size()];
        for (int i = 0; i < flightIdList.size(); i++) {
            flightIds[i] = String.valueOf(flightIdList.get(i));
        }
        return flightIds;
    }

    // 返回所有order的orderid到string数组中
    public String[] getOrderId() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<Integer> orderIdList = new ArrayList<>();
        for (Order order : orderList) {
            orderIdList.add(order.getOrderId());
        }
        String[] orderIds = new String[orderIdList.size()];
        for (int i = 0; i < orderIdList.size(); i++) {
            orderIds[i] = String.valueOf(orderIdList.get(i));
        }
        return orderIds;
    }

    // 返回所有order的seat到string数组中
    public String[] getSeat() {
        List<Order> orderList = jsonO.readArray(Order.class);
        List<Integer> seatList = new ArrayList<>();
        for (Order order : orderList) {
            seatList.add(order.getSeatId());
        }
        String[] seats = new String[seatList.size()];
        // 如果seat为-1，则显示Not chosen
        for (int i = 0; i < seatList.size(); i++) {
            if (seatList.get(i) == -1) {
                seats[i] = "Not chosen";
            } else {
                seats[i] = String.valueOf(seatList.get(i));
            }
        }
        return seats;
    }

    // 返回所有order的food到string数组中
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

    // 返回所有order的总数
    public int getOrderNum() {
        List<Order> orderList = jsonO.readArray(Order.class);
        return orderList.size();
    }

    /**
     * This method is to log out and close the system.
     */
    @Override
    public void logout() {
        System.exit(1);
    }
}
