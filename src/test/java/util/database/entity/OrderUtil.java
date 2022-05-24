package util.database.entity;

import entity.Order;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code OrderUtil}
 *
 * The class provides methods to control Order.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class OrderUtil extends DataBaseUtil {
    public OrderUtil() {
        super("src/main/resources/json/Order.json");
    }

    @Override
    public Object get(String orderId) {
        List<Order> orders=controller.readArray(Order.class);
        if(orders==null)
            fail("No order");

        for(Order o:orders){
            if (Objects.equals(o.getOrderId(), orderId))
                return o;
        }
        return null;
    }

    @Override
    public void add(Object obj) {
        Order o = (Order) obj;
        if(get(o.getOrderId()) != null)
            fail("The ID has existed!");
        List<Order> orders = controller.readArray(Order.class);
        if(orders == null)
            orders = new ArrayList<>();
        orders.add(o);
        controller.writeArray(orders);

        CustomerUtil customerUtil = new CustomerUtil();
        FlightUtil flightUtil = new FlightUtil();

        // update order for customer
        customerUtil.updateCustomerOrder(o.getUserId(), o.getOrderId());
        // update customer for flight
        flightUtil.updateFlightCustomers(o.getFlightId(), o.getUserId());
        // update occupied seat for flight
        flightUtil.updateFlightOccupiedSeat(o.getFlightId(), o.getSeatId());
    }
}
