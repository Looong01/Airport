package service;

import org.junit.jupiter.api.Test;
import service.impl.StaffServiceImpl;

public class StaffTest {
     StaffService service=new StaffServiceImpl();

    static StaffServiceImpl ss = new StaffServiceImpl();

    //test for loginByPasswd
    @Test
    public void testLoginByPasswd(){
        System.out.println(service.loginByPasswd("140109200010204817","123456"));
        System.out.println(service.loginByPasswd("140109200010204817","4194"));
    }

    //test for checkFlight
    @Test
    public void testCheckFlight(){
        int[] result=service.checkFlight("MH1001");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        result=service.checkFlight("MH789789");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
    }


    //test for CheckFlight
    @Test
    public void testGetFlightIds(){
        System.out.println(service.getFlightIds());
    }

    //test for getGateId
    @Test
    public void testGetGateId(){
        System.out.println(service.getGateId("MH1001"));
        System.out.println(service.getGateId("MH789789"));
    }

    //test for getFromCity
    @Test
    public void testGetFromCity(){
        System.out.println(service.getFromCity("MH1001"));
        System.out.println(service.getFromCity("MH789789"));
    }

    //test for getToCity
    @Test
    public void testGetToCity(){
        System.out.println(service.getToCity("MH1001"));
        System.out.println(service.getToCity("MH789789"));
    }

    //test for getTime
    @Test
    public void testGetTime(){
        System.out.println(service.getTime("MH1001"));
        System.out.println(service.getTime("MH789789"));
    }

    //test for getOrderId
    @Test
    public void testGetOrderId(){
        System.out.println(service.getOrderId(1));
        System.out.println(service.getOrderId(1125445));
    }

    //test for getStatus
    @Test
    public void testGetStatus(){
        System.out.println(service.getStatus("aHB9ZlCF9H"));
        System.out.println(service.getStatus("dsaofiodfi"));
    }

    //test for getUserIds
    @Test
    public void testGetUserIds(){
        System.out.println(service.getUserIds("MH1003"));
        System.out.println(service.getUserIds("MH789789"));
    }

    //test for getCardId
    @Test
    public void testGetCardId(){
        System.out.println(service.getCardId(1));
        System.out.println(service.getCardId(1125445));
    }

    //test for getName
    @Test
    public void testGetName(){
        System.out.println(service.getName(1));
        System.out.println(service.getName(1125445));
    }

    //test for getFlightId
    @Test
    public void testGetFlightId(){
        System.out.println(service.getFlightId("aHB9ZlCF9H"));
        System.out.println(service.getFlightId("dsaofiodfi"));
    }

    //test for getFlightId
    @Test
    public void testGetOrder(){
        System.out.println(service.getFlightId());
    }

    //test for getOrderId
    @Test
    public void testGetOrderId2(){
        System.out.println(service.getOrderId());
    }

    //test for getSeat
    @Test
    public void testGetSeat(){
        System.out.println(service.getSeat());
    }

    //test for getFood
    @Test
    public void testGetFood(){
        System.out.println(service.getFood());
    }

    //test for getOrderNum
    @Test
    public void testGetOrderNum(){
        System.out.println(service.getOrderNum());
    }
}
