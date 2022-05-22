package util.database.entity;

import entity.Order;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class {@code OrderUtil}
 *
 * <p> This class provides some method that help get some
 * information about orders
 *
 * @author Chenyang He
 * @version 1.2
 *
 */
public class OrderUtil {

    //最底层的基础方法，不要动，其他的联合修改都是调用这次底层方法
    //order的增，删，改，查，统计数量
    private final JSONController jsonO=new JSONController("src/main/resources/json/Order.json");
    private final CustomerUtil customerUtil = new CustomerUtil();
    private final FlightUtil flightUtil = new FlightUtil();

    /**
     * Single add method
     * <p>This method will add the single order in the file</>
     *
     * @param o the order will be added
     *
     */
    public void addOrder(Order o) {
        if(this.findOrder(o.getOrderId()) != null) {
            System.out.println("The ID has existed!");
        }
        List<Order> orders = jsonO.readArray(Order.class);
        if(orders == null)
            orders = new ArrayList<>();
        orders.add(o);
        jsonO.writeArray(orders);

        // update order for customer
        customerUtil.updateCustomerOrder(o.getUserId(), o.getOrderId());
        // update customer for flight
        flightUtil.updateFlightCustomers(o.getFlightId(), o.getUserId());
    }

    /**
     * Single delete method
     * <p>This method will remove the order with specified userId</>
     *
     * @return true if success, false if failed
     */
    public boolean removeOrder(int orderId){
        if(this.findOrder(orderId)==null){
            System.out.println("The ID do not exist!");
            return false;
        }
        List<Order> orders = jsonO.readArray(Order.class);
        if(orders==null){
            System.out.println("No orders");
            return false;
        }
        orders.removeIf(o -> o.getOrderId() == orderId);
        jsonO.writeArray(orders);
        return true;
    }

    /**
     * choose seat
     * @param orderId order ID
     * @param seatId seat ID
     * @return true if success
     */
    public boolean updateOrderSeat(int orderId, int seatId) {
        List<Order> orders = jsonO.readArray(Order.class);
        if(orders == null) {
            System.out.println("No orders");
            return false;
        }
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setSeatId(seatId);
                order.setStatus("W");
                jsonO.writeArray(orders);
                return true;
            }
        }
        System.out.println("The order ID not found");
        return false;
    }

    /**
     * choose food
     * @param orderId order ID
     * @param food Food
     * @return true if success
     */
    public boolean updateOrderFood(int orderId, String food) {
        List<Order> orders = jsonO.readArray(Order.class);
        if(orders == null) {
            System.out.println("No orders");
            return false;
        }
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setFood(food);
                jsonO.writeArray(orders);
                return true;
            }
        }
        System.out.println("The order ID not found");
        return false;
    }

    /**
     * Single find method
     * <p>This method will find the order with specified ID</>
     *
     * @param orderId ID will be used
     * @return Order
     */
    public Order findOrder(int orderId){
        List<Order> orders=jsonO.readArray(Order.class);
        if(orders==null){
            System.out.println("No order");
            return null;
        }
        for(Order o:orders){
            if (o.getOrderId()==orderId){
                return o;
            }
        }
        return null;
    }

    /**
     * Count number method
     * <p>This method will return the number of orders in the file</>
     *
     * @return number of order
     */
    public int getTotalOrder(){
        List<Order> orders=jsonO.readArray(Order.class);
        if(orders==null){
            System.out.println("No flight");
            return 0;
        }
        return orders.size();
    }
}
