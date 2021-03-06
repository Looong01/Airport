package service.impl;

import entity.Flight;
import entity.Order;
import entity.user.Customer;
import org.bytedeco.javacv.*;

import javax.swing.*;

import service.CustomerService;
import util.file.JSONController;
import util.scan.QRCodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service class {@code CustomerServiceImpl}
 *
 * <p> This class is the implement of the CustomerService {@code CustomerService}
 * These abstract methods will be completed in this class.
 * And this is the only class which interaction with the DAO layer.
 * This can help the program decouple.
 *
 * @author Chenyang He
 * @author Hao Sun
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
    public Order getOrder(String orderId) {
        List<Order> orders = orderController.readArray(Order.class);
        if(orders == null) {
            System.out.println("No order");
            return null;
        }
        for(Order order:orders) {
            if (order.getOrderId().equals(orderId))
                return order;
        }
        return null;
    }

    @Override
    public Flight getFlight(String flightId) {
        List<Flight> flights = flightController.readArray(Flight.class);
        if(flights == null) {
            System.out.println("No flight");
            return null;
        }
        for(Flight flight : flights) {
            if(Objects.equals(flight.getFlightId(), flightId))
                return flight;
        }
        return null;
    }

    @Override
    public Customer loginByCardId(String cardId) {
        List<Customer> customers = customerController.readArray(Customer.class);
        if(customers == null) {
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
    public Customer loginByScanId() {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try (Java2DFrameConverter converter = new Java2DFrameConverter()) {
            CanvasFrame canvas;
            Frame frame;
            String cardId = null;
            try{
                grabber.start();
                canvas = new CanvasFrame("Camera");
                canvas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                canvas.toFront();
                while (canvas.isDisplayable()) {
                    frame = grabber.grab();
                    canvas.showImage(frame);
                    cardId = QRCodeUtil.decode(converter.convert(frame));
                    if (cardId != null) {
                        canvas.dispose();
                        grabber.close();
                        break;
                    }
                }
            }catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
            return this.loginByCardId(cardId);
        }catch (Exception e) {
            e.printStackTrace();
        }
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
            if (Objects.equals(flight.getFlightId(), order.getFlightId())) {
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
                    if (o.getOrderId().equals(order.getOrderId())) {
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
            if (Objects.equals(o.getOrderId(), order.getOrderId())) {
                o.setFood(order.getFood());
                orderController.writeArray(orders);
                return true;
            }
        }
        System.out.println("The order ID not found");
        return false;
    }
}