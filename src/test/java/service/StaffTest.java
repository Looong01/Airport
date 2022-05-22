package service;


import org.junit.jupiter.api.Test;
import service.impl.StaffServiceImpl;


public class StaffTest {

    @Test
    public void test(){
        //test for login
        //StaffService ss=new StaffServiceImpl();
        //System.out.println(ss.LoginByPasswd(11, "123"));

        /*
         * Write a flight info into Flight.json
         * int[] newOrder = {1, 2, 3};
         * String[] foodOrder = {"rice", "noodle"};
         * Customer customer = new Customer(1, "Hao Sun", 1,"11111111", "Male", "+86 12345", newOrder);
         * ArrayList<Customer> customerList = new ArrayList<>();
         * customerList.add(customer);
         * JSONController jsonF=new JSONController("Flight.json");
         * Flight flight = new Flight(1000, "2022-01-01 10:00 ---- 2022-01-01 12:00", "Beijing", "Shanghai", 614, null, customerList, foodOrder);
         * jsonF.write(flight);
         */


         //Write order info into Order.json
         //JSONController jsonO=new JSONController("Order.json");
         //Order order1 = new Order(1, "C", 1000, 10, "rice");
         //Order order2 = new Order(4, "C", 1000, 11, "rice");
         //List<Order> orderList = new ArrayList<Order>();
         //orderList.add(order1);
         //orderList.add(order2);
         //jsonO.writeArray(orderList);

        //Test for checkUser method
        //StaffService ss=new StaffServiceImpl();
        //System.out.println(ss.checkUser("11111111", 1000));

        //Test for checkFlight method
        //StaffService ss=new StaffServiceImpl();
        //System.out.println(Arrays.toString(ss.checkFlight(1000)));

        //Test for checkOrder method
        StaffService ss=new StaffServiceImpl();
        //System.out.println(ss.checkOrder(1000));
        System.out.println(ss.checkFlight(1));

        //ss.logout();
    }
}
