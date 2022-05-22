package service;

import entity.Flight;
import entity.Order;
import entity.user.Customer;

import java.util.ArrayList;

/**
 * Service Interface {@code CustomerService}
 *
 * <p> This interface is used to provide the
 * service for customer.
 *
 * @author Chenyang He & Hao Sun
 * @version 1.2
 *
 */
public interface CustomerService {
    Customer getCustomerById(int userId);

    Order getOrder(int orderId);

    Flight getFlight(int flightId);

    Order LoginByOrderId(int orderId);

    Customer LoginByCardId(String cardId);
    Customer LoginByScanId();

    boolean chooseSeat (Order order);

    boolean chooseFood (Order order);
}
