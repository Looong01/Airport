package service;

import org.junit.jupiter.api.Test;
import service.impl.StaffServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {
     StaffService service=new StaffServiceImpl();

    static StaffServiceImpl ss = new StaffServiceImpl();

    //test for loginByPasswd
    @Test
    public void testLoginByPasswd(){
        assertTrue(service.loginByPasswd("140109200010204817","123456"));
        assertFalse(service.loginByPasswd("140109200010204817","4194"));
    }

    //test for checkFlight
    @Test
    public void testCheckFlight(){
        assertArrayEquals(new int[] {2, 1, 0, 3}, service.checkFlight("MH1001"));
        assertArrayEquals(new int[] {0, 0, 0, 0}, service.checkFlight("MH789789"));
    }

    //test for getGateId
    @Test
    public void testGetGateId(){
        assertEquals(10, service.getGateId("MH1001"));
        assertEquals(-1, service.getGateId("MH789789"));
    }

    //test for getFromCity
    @Test
    public void testGetFromCity(){
        assertEquals("Taiyuan Wusu", service.getFromCity("MH1001"));
        assertNull(service.getFromCity("MH789789"));
    }

    //test for getToCity
    @Test
    public void testGetToCity(){
        assertEquals("Beijing Capital", service.getToCity("MH1001"));
        assertNull(service.getToCity("MH789789"));
    }

    //test for getTime
    @Test
    public void testGetTime(){
        assertEquals("Wed May 25 05:37:42", service.getTime("MH1001"));
        assertNull(service.getTime("MH789789"));
    }

    //test for getStatus
    @Test
    public void testGetStatus(){
        assertEquals("C", service.getStatus("aHB9ZlCF9H"));
        assertNull(service.getStatus("dsaofiodfi"));
    }

    //test for getCardId
    @Test
    public void testGetCardId(){
        assertEquals("140109200010204817", service.getCardId(1));
        assertNull(service.getCardId(1125445));
    }

    //test for getName
    @Test
    public void testGetName(){
        assertEquals("Chenyang He", service.getName(1));
        assertNull(service.getName(1125445));
    }

    //test for getFlightId
    @Test
    public void testGetFlightId(){
        assertEquals("MH1004", service.getFlightId("aHB9ZlCF9H"));
        assertNull(service.getFlightId("dsaofiodfi"));
    }

    //test for getOrderNum
    @Test
    public void testGetOrderNum(){
        assertEquals(8, service.getOrderNum());
    }
}
