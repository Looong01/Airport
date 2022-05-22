package util.database.entity;

import entity.user.Customer;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class {@code CustomerUtil}
 *
 * <p> This class provides some method that help get some
 * information about customers
 *
 * @author Chenyang He
 * @version 1.2
 *
 */
public class CustomerUtil {

    //最底层的基础方法，不要动，其他的联合修改都是调用这次底层方法
    //customer的增,删,改,查,统计数量

    private final JSONController jsonC=new JSONController("src/main/resources/json/Customer.json");

    /**
     * Single add method
     * <p>This method will add the single customer in the file</>
     *
     * @param c the customer will be added
     *
     */
    public void addCustomer(Customer c){
        if(this.findCustomer(c.getUserId())!=null){
            System.out.println("The ID has existed");
            return;
        }
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            ArrayList<Customer> cc=new ArrayList<>();
            cc.add(c);
            jsonC.writeArray(cc);
            return ;
        }
        customers.add(c);
        jsonC.writeArray(customers);

    }

    /**
     * Single delete method
     * <p>This method will remove the customer with specified userId</>
     *
     * @return true if success, false if failed
     */
    public boolean removeCustomer(int userId){
        if(this.findCustomer(userId)==null){
            System.out.println("The ID do not exist");
            return false;
        }
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            System.out.println("No customer exist!");
            return false;
        }
        customers.removeIf(c -> c.getUserId() == userId);
        jsonC.writeArray(customers);
        return true;
    }

    /**
     * Single update method
     * This method will update the telephone number of the customer with specified userId
     *
     * @return true if success, false if failed
     */
    public boolean updateCustomerTel(int userId,String tel){
        if(this.findCustomer(userId)==null){
            System.out.println("The ID do not exist");
            return false;
        }
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            System.out.println("No customer exist!");
            return false;
        }
        for(Customer c: customers){
            if(c.getUserId()==userId){
                c.setTel(tel);
                return true;
            }
        }
        return false;
    }

    /**
     * Single update method
     * This method will update the order list of the customer with specified userId
     * If exist, then delete; if not exist, then append
     *
     * @return true if success, false if failed
     */
    public boolean updateCustomerOrder(int userId, int order) {
        List<Customer> customers = jsonC.readArray(Customer.class);
        if(customers == null){
            System.out.println("No customer exist!");
            return false;
        }
        for(Customer c: customers) {
            if(c.getUserId() == userId) {
                ArrayList<Integer> orders = c.getOrder();
                for (Integer o : orders) {
                    if (o == order) { // delete order
                        orders.remove(o);
                        c.setOrder(orders);
                        jsonC.writeArray(customers);
                        return true;
                    }
                }

                // append order
                orders.add(order);
                c.setOrder(orders);
                jsonC.writeArray(customers);
                return true;
            }
        }
        System.out.println("The User ID not found");
        return false;
    }

    /**
     * Single find method
     * <p>This method will find the customer with specified userId</>
     *
     * @param userId The ID will be used.
     * @return customer
     */
    public Customer findCustomer(int userId){
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            System.out.println("No customer");
            return null;
        }
        for(Customer c: customers){
            if(c.getUserId()==userId){
                return c;
            }
        }
        return null;
    }

    /**
     * Single find method
     * <p>This method will find the customer with specified userId</>
     *
     * @param cardId The ID will be used.
     * @return customer
     */
    public Customer findCustomerByCard(String cardId){
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            System.out.println("No customer exist!");
            return null;
        }
        for(Customer c: customers){
            if(c.getCardId().equals(cardId)){
                return c;
            }
        }
        return null;
    }

    /**
     * Count number method
     * <p>This method will return the number of customers in the file</>
     *
     * @return number of customer
     */
     public int getTotalCustomer() {
        List<Customer> customers=jsonC.readArray(Customer.class);
        if(customers==null){
            return 0;
        }
        return customers.size();
    }
}
