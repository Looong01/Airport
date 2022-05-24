package service.impl;

import entity.Flight;
import entity.Order;
import entity.user.Customer;
import service.CustomerService;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class {@code CustomerServiceImpl}
 *
 * <p> This class is the implement of the CustomerService {@code CustomerService}
 * These abstract methods will be completed in this class.
 * And this is the only class which interaction with the DAO layer.
 * This can help the program decouple.
 *
 * @author Chenyang He & Hao Sun
 * @author Ziyao Wang
 * @version 1.2
 * @version 1.5
 *
 */
public class CustomerServiceImpl implements CustomerService {
    private final JSONController customerController = new JSONController("src/main/resources/json/Customer.json");
    private final JSONController orderController = new JSONController("src/main/resources/json/Order.json");
    private final JSONController flightController = new JSONController("src/main/resources/json/Flight.json");

    @Override
    public Customer getCustomer(int userId) {
        List<Customer> customers = customerController.readArray(Customer.class);
        if(customers == null) {
            System.out.println("No customer");
            return null;
        }
        for(Customer customer: customers){
            if(customer.getUserId() == userId)
                return customer;
        }
        return null;
    }

    @Override
    public Order getOrder(int orderId) {
        List<Order> orders = orderController.readArray(Order.class);
        if(orders == null) {
            System.out.println("No order");
            return null;
        }
        for(Order order:orders) {
            if (order.getOrderId() == orderId)
                return order;
        }
        return null;
    }

    @Override
    public Flight getFlight(int flightId) {
        List<Flight> flights = flightController.readArray(Flight.class);
        if(flights == null) {
            System.out.println("No flight");
            return null;
        }
        for(Flight flight : flights) {
            if(flight.getFlightId() == flightId)
                return flight;
        }
        return null;
    }

    @Override
    public Order LoginByOrderId(int orderId) {
        return getOrder(orderId);
    }

    @Override
    public Customer LoginByCardId(String cardId) {
        List<Customer> customers = customerController.readArray(Customer.class);
        if(customers == null){
            System.out.println("No customer exist!");
            return null;
        }
        for(Customer customer: customers) {
            if(customer.getCardId().equals(cardId))
                return customer;
        }
        return null;
    }

    @Override
    public Customer LoginByScanId() {
        // TO DO implementation
        return null;
    }

    @Override
    public boolean chooseSeat(Order order) {
        if (order.getSeatId() == -1)
            return false;
        List<Flight> flights = flightController.readArray(Flight.class);
        if(flights == null) {
            System.out.println("No flight");
            return false;
        }
        for (Flight flight : flights) {
            if (flight.getFlightId() == order.getFlightId()) {
                ArrayList<Integer> occupiedSeats = flight.getOccupiedSeats();
                occupiedSeats.add(order.getSeatId());
                flight.setOccupiedSeats(occupiedSeats);
                flightController.writeArray(flights);

                List<Order> orders = orderController.readArray(Order.class);
                if(orders == null) {
                    System.out.println("No orders");
                    return false;
                }
                for (Order o : orders) {
                    if (o.getOrderId() == order.getOrderId()) {
                        o.setSeatId(order.getSeatId());
                        o.setStatus("W");
                        orderController.writeArray(orders);
                        return true;
                    }
                }

                System.out.println("The order ID not found");
                return false;
            }
        }

        System.out.println("The flight ID not found");
        return false;
    }

    @Override
    public boolean chooseFood(Order order) {
        List<Order> orders = orderController.readArray(Order.class);
        if(orders == null) {
            System.out.println("No orders");
            return false;
        }
        for (Order o : orders) {
            if (o.getOrderId() == order.getOrderId()) {
                o.setFood(order.getFood());
                orderController.writeArray(orders);
                return true;
            }
        }
        System.out.println("The order ID not found");
        return false;
    }
}