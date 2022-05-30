package service;

import entity.Flight;
import entity.Order;
import entity.user.Customer;

/**
 * Service Interface {@code CustomerService}
 *
 * <p> This interface is used to provide the
 * service for customer.
 *
 * @author Chenyang He
 * @author Hao Sun
 * @author Ziyao Wang
 * @version 1.2
 * @version 1.5
 */
public interface CustomerService {
    /**
     * Find customer with userId
     *
     * @param userId ID
     * @return customer
     */
    Customer getCustomer(int userId);

    /**
     * FInd order with orderId
     *
     * @param orderId ID
     * @return order
     */
    Order getOrder(String orderId);

    /**
     * Find flight with ID
     *
     * @param flightId ID
     * @return flight
     */
    Flight getFlight(String flightId);

    /**
     * The customer login with the card ID.
     *
     * @param cardId Card ID
     * @return Customer
     */
    Customer loginByCardId(String cardId);

    /**
     * The customer login with received QR code
     * that will be scanned by the computer and
     * decoded for cardId.
     *
     * @return true if success, false if failed
     */
    Customer loginByScanId();

    /**
     * The customer chooses the seat with his
     * order. They also can pay for the different
     * kind of seat. With this function, the status
     * will be set to the Waiting by default.
     *
     * @param order Order
     * @return true if success, false if failed
     */
    boolean chooseSeat (Order order);

    /**
     * The customer chooses the food with his
     * order.
     *
     * @param order Order
     * @return true if success, false if failed
     */
    boolean chooseFood (Order order);
}