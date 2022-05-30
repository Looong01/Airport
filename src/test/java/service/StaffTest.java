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
        assertTrue(ss.loginByPasswd("140109200010204817","123456"));
        assertFalse(ss.loginByPasswd("140109200010204817","4194"));
    }

    //test for checkFlight
    @Test
    public void testCheckFlight(){
        assertArrayEquals(new int[] {2, 1, 0, 3}, ss.checkFlight("MH1001"));
        assertArrayEquals(new int[] {0, 0, 0, 0}, ss.checkFlight("MH789789"));
    }

    //test for getGateId
    @Test
    public void testGetGateId(){
        assertEquals(10, ss.getGateId("MH1001"));
        assertEquals(-1, ss.getGateId("MH789789"));
    }

    //test for getFromCity
    @Test
    public void testGetFromCity(){
        assertEquals("Taiyuan Wusu", ss.getFromCity("MH1001"));
        assertNull(ss.getFromCity("MH789789"));
    }

    //test for getToCity
    @Test
    public void testGetToCity(){
        assertEquals("Beijing Capital", ss.getToCity("MH1001"));
        assertNull(ss.getToCity("MH789789"));
    }

    //test for getTime
    @Test
    public void testGetTime(){
        assertEquals("Sun May 29 17:42:41", ss.getTime("MH1001"));
        assertNull(ss.getTime("MH789789"));
    }

    //test for getStatus
    @Test
    public void testGetStatus(){
        assertEquals("C", ss.getStatus("aHB9ZlCF9H"));
        assertNull(ss.getStatus("dsaofiodfi"));
    }

    //test for getCardId
    @Test
    public void testGetCardId(){
        assertEquals("140109200010204817", ss.getCardId(1));
        assertNull(ss.getCardId(1125445));
    }

    //test for getName
    @Test
    public void testGetName(){
        assertEquals("Chenyang He", ss.getName(1));
        assertNull(ss.getName(1125445));
    }

    //test for getFlightId
    @Test
    public void testGetFlightId(){
        assertEquals("MH1004", ss.getFlightId("aHB9ZlCF9H"));
        assertNull(ss.getFlightId("dsaofiodfi"));
    }

    //test for getOrderNum
    @Test
    public void testGetOrderNum(){
        assertEquals(8, ss.getOrderNum());
    }
}