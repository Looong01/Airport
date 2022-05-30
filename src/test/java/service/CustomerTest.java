package service;

import entity.Order;
import org.junit.jupiter.api.Test;
import service.impl.CustomerServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    CustomerService service=new CustomerServiceImpl();
    static CustomerServiceImpl cs = new CustomerServiceImpl();

    //Test for getCustomer(int userId)
    @Test
    public void testGetCustomer() {
        assertNotNull(cs.getCustomer(1));
        assertNull(cs.getCustomer(114514));
    }

    //Test for getOrder(String orderId)
    @Test
    public void testGetOrder() {
        assertNotNull(cs.getOrder("BJEV1RmqVm"));
        assertNull(cs.getOrder("BJEV123qVm1"));
    }

    //Test for getFlight(int flightId)
    @Test
    public void testGetFlight() {
        assertNotNull(cs.getFlight("MH1001"));
        assertNull(cs.getFlight("MH789789"));
    }

    //Test for LoginByCardId(String cardId)
    @Test
    public void testLoginByCardId() {
        assertNotNull(cs.loginByCardId("140109200010204817"));
        assertNull(cs.loginByCardId("140109201234504818"));
    }

    //Test for chooseSeat()
    @Test
    public void testChooseSeat() {
        Order order = cs.getOrder("BJEV1RmqVm");
        order.setSeatId(2);
        assertTrue(cs.chooseSeat(order));
        assertNotNull(order);
        assertNotNull(cs.getFlight("MH1001"));
    }

    //Test for chooseFood()
    @Test
    public void testChooseFood() {
        Order order = cs.getOrder("BJEV1RmqVm");
        order.setFood("Standard");
        assertTrue(cs.chooseFood(order));
        assertNotNull(order);
    }

    @Test
    public void logInByScan(){
        assertNotNull(service.loginByScanId());
    }
}