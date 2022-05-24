package util.database.entity;

import entity.user.Customer;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

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
    public Object get(int userId) {
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers==null)
            fail("No customer");

        for(Customer c: customers){
            if(c.getUserId() == userId)
                return c;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Customer c = (Customer) o;
        if(get(c.getUserId()) != null)
            fail("The ID has existed");
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers==null)
            customers = new ArrayList<>();
        customers.add(c);
        controller.writeArray(customers);
    }

    /**
     * Update the order list of the customer with specified userId
     * If exist, then delete; if not exist, then append
     */
    void updateCustomerOrder(int userId, int order) {
        List<Customer> customers = controller.readArray(Customer.class);
        if(customers == null)
            fail("No customer exist!");

        for(Customer c: customers) {
            if(c.getUserId() == userId) {
                ArrayList<Integer> orders = c.getOrder();
                for (Integer o : orders) {
                    if (o == order) { // delete order
                        orders.remove(o);
                        c.setOrder(orders);
                        controller.writeArray(customers);
                        return;
                    }
                }

                // append order
                orders.add(order);
                c.setOrder(orders);
                controller.writeArray(customers);
                return;
            }
        }
        fail("The User ID not found");
    }
}
