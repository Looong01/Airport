package util.database.entity;

import entity.user.Customer;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code CustomerUtil}
 *
 * The class provides methods to control Customer.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class CustomerUtil extends DataBaseUtil {
    public CustomerUtil() {
        super("src/main/resources/json/Customer.json");
    }

    @Override
    public Object get(String userId) {
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers==null)
            fail("No customer");

        for(Customer c: customers){
            if(c.getUserId() == Integer.parseInt(userId))
                return c;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Customer c = (Customer) o;
        if(get(c.getUserId() + "") != null)
            fail("The ID has existed");
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers==null)
            customers = new ArrayList<>();
        customers.add(c);
        controller.writeArray(customers);
    }

    /**
     * Update the order list of the customer with specified userId
     * If exists, then delete; if not exist, then append
     */
    void updateCustomerOrder(int userId, String order) {
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers == null)
            fail("No customer exist!");

        for(Customer c: customers) {
            if(c.getUserId() == userId) {
                ArrayList<String> orders = c.getOrders();
                for (String o : orders) {
                    if (Objects.equals(o, order)) { // delete order
                        orders.remove(o);
                        c.setOrders(orders);
                        controller.writeArray(customers);
                        return;
                    }
                }

                // append order
                orders.add(order);
                c.setOrders(orders);
                controller.writeArray(customers);
                return;
            }
        }
        fail("The User ID not found");
    }
}
