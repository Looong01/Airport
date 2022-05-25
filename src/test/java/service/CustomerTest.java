package service;

import entity.Order;
import org.junit.jupiter.api.Test;
import service.impl.CustomerServiceImpl;


public class CustomerTest {
    CustomerService service=new CustomerServiceImpl();

    static CustomerServiceImpl cs = new CustomerServiceImpl();

    //Test for getCustomer(int userId)
    @Test
    public void testGetCustomer() {
        System.out.println(cs.getCustomer(1));
    }

    //Test for getOrder(String orderId)
    @Test
    public void testGetOrder() {
        System.out.println(cs.getOrder("BJEV1RmqVm"));
    }

    //Test for getFlight(int flightId)
    @Test
    public void testGetFlight() {
        System.out.println(cs.getFlight("MH1001"));
    }

    //Test for LoginByCardId(String cardId)
    @Test
    public void testLoginByCardId() {
        System.out.println(cs.loginByCardId("140109200010204817"));
    }

    //Test for chooseSeat()
    @Test
    public void testChooseSeat() {
        Order order = cs.getOrder("BJEV1RmqVm");
        order.setSeatId(2);
        System.out.println(cs.chooseSeat(order));
        System.out.println(order);
        System.out.println(cs.getFlight("MH1001"));
    }

    //Test for chooseFood()
    @Test
    public void testChooseFood() {
        Order order = cs.getOrder("BJEV1RmqVm");
        order.setFood("Standard");
        System.out.println(cs.chooseFood(order));
        System.out.println(order);
    }

    @Test
    public void logInByScan(){
        //service.LoginByScanId();
        System.out.println(service.loginByScanId());
    }


}

