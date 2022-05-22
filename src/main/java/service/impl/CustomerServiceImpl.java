package service.impl;

import entity.Flight;
import entity.Order;
import entity.user.Customer;
import service.CustomerService;
import util.database.DataBaseUtil;

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
 * @version 5.0
 *
 */
public class CustomerServiceImpl implements CustomerService {
    private final DataBaseUtil util = new DataBaseUtil();

    /**
     * Find customer with userId
     *
     * @param userId ID
     * @return customer
     */
    @Override
    public Customer getCustomerById(int userId) {
        return util.cUtil.findCustomer(userId);
    }

    /**
     * FInd order with orderId
     *
     * @param orderId ID
     * @return order
     */
    @Override
    public Order getOrder(int orderId) {
        return util.oUtil.findOrder(orderId);
    }

    /**
     * Find flight with ID
     *
     * @param flightId ID
     * @return flight
     */
    @Override
    public Flight getFlight(int flightId) {
        return util.fUtil.findFlight(flightId);
    }

    /**
     * The customer login by the orderId.
     *
     * @param orderId Order ID
     * @return Order
     */
    @Override
    public Order LoginByOrderId(int orderId) {
        return util.oUtil.findOrder(orderId);
    }

    /**
     * The customer login with the card ID.
     *
     * @param cardId Card ID
     * @return Customer
     */
    @Override
    public Customer LoginByCardId(String cardId) {
        return util.cUtil.findCustomerByCard(cardId);
    }

    /**
     * The customer will login with the card ID,
     * which will be scanned by the computer, the
     * customer should enter their card ID.
     *
     * @return true if success, false if failed
     */
    @Override
    public Customer LoginByScanId() {
        /*Scanner s=new Scanner(System.in);
        String cardId=s.next();
        List<Order> orders=jsonO.readArray(Order.class);
        for (Order order : orders) {
            if(order.getOrderId()==Integer.parseInt(cardId)){
                return true;
            }
        }*/
        return null;
    }

    /**
     * The customer will choose the seat with his
     * order. They also can pay for the different
     * kind of seat. With this function, the status
     * will be set to the Waiting by default.
     *
     * @return true if success, false if failed
     */
    @Override
    public boolean chooseSeat(Order order) {
        if (util.fUtil.updateFlightOccupiedSeat(order.getFlightId(), order.getSeatId()))
            return util.oUtil.updateOrderSeat(order.getOrderId(), order.getSeatId());
        return false;
        /*List<Order> orders=jsonO.readArray(Order.class);
        List<Flight> flights=jsonF.readArray(Flight.class);

        for (Order o : orders) {
            if(o.getOrderId()==order.getOrderId()){
                int flightID=o.getFlightId();
                for(Flight f:flights){
                    if(f.getFlightId()==flightID){
                        ArrayList<Integer> seatList=f.getSeats();
                        seatList.remove(Integer.valueOf(order.getSeatId()));
                        f.setSeats(seatList);
                        o.setSeatId(order.getSeatId());
                        o.setStatus("W");
                        jsonO.writeArray(orders);
                        jsonF.writeArray(flights);
                        return true;
                    }
                }
            }
        }
        return false;*/
    }

    @Override
    public boolean chooseFood(Order order) {
        return util.oUtil.updateOrderFood(order.getOrderId(), order.getFood());
    }

    /*
     * The plane card's information will be printed
     *
     * @return String with all the information
     *
    public String PrintCard(int orderId) {
        StringBuilder card= new StringBuilder("Card Information\n");
        List<Order> orders=jsonO.readArray(Order.class);
        List<Flight> flights=jsonF.readArray(Flight.class);
        for (Order order : orders) {
            if(order.getOrderId()==orderId){
                card.append(order);
                int flightID=order.getFlightId();
                for(Flight f:flights){
                    if(f.getFlightId()==flightID){
                        card.append(f);
                    }
                }
            }
        }
        return card.toString();
    }

    @Override
    public String printCard(int orderId) {
        StringBuilder card= new StringBuilder("Digital flight Card      \n");
        List<Order> orders=jsonO.readArray(Order.class);
        List<Flight> flights=jsonF.readArray(Flight.class);
        for (Order order : orders) {
            if(order.getOrderId()==orderId){
                card.append("Order Id:").append(order.getOrderId()).append("        \n");
                card.append("Flight Id:").append(order.getFlightId()).append("      \n");
                card.append("Food:").append(order.getFood()).append("       \n");
                card.append("Seat Id:").append(order.getSeatId()).append("      \n");
                int flightID=order.getFlightId();
                for(Flight f:flights){
                    if(f.getFlightId()==flightID){
                        card.append("Time:").append(f.getTime()).append("       \n");
                        card.append("Departure:").append(f.getFromCity()).append("      \n");
                        card.append("Destination:").append(f.getToCity()).append("      \n");
                        card.append("Gate Id:").append(f.getGateId()).append("      \n");
                    }
                }
            }
        }
        return card.toString();
    }*/
}