package util.database;

import entity.*;
import entity.user.*;
import org.junit.jupiter.api.Test;
import util.database.entity.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/**
 * Test class for generation of Plane.json, Staff.json, Flight.json, Customer.json, Order.json, and Bank.json
 *
 * @author Chenyang He
 * @author Ziyao Wang
 * @version 1.5
 */
public class DatabaseTest {
    @Test
    public void PlaneTest() {
        DataBaseUtil util = new PlaneUtil();
        util.removeAll();
        util.add(new Plane("B-1001"));
        util.add(new Plane("B-1002"));
        /*util.add(new Plane("B-1003"));
        util.add(new Plane("B-1004"));
        util.add(new Plane("B-1005"));
        util.add(new Plane("B-1006"));*/
    }

    @Test
    public void StaffTest() {
        DataBaseUtil util = new StaffUtil();
        util.removeAll();
        util.add(new Staff(1,"Chenyang He","140109200010204817", "123456"));
        util.add(new Staff(2,"Hao Sun","130178200102295674","qwerty"));
    }

    @Test
    public void FlightTest() {
        DataBaseUtil util = new FlightUtil();
        util.removeAll();
        util.add(new Flight("B-1001", "MH1001", LocalDateTime.now(ZoneOffset.of("-8")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Beijing Capital", 10));
        util.add(new Flight("B-1001", "MH1002", LocalDateTime.now(ZoneOffset.of("-4")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu","Shanghai Pudong", 20));
        util.add(new Flight("B-1002", "MH1003", LocalDateTime.now(ZoneOffset.of("+4")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Beijing Daxing", 30));
        util.add(new Flight("B-1002", "MH1004", LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Guangzhou Baiyun", 40));
        /*util.add(new Flight("B-1002", "MH1005", LocalDateTime.now(ZoneOffset.of("-4")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Shanghai Hongqiao", 50));
        util.add(new Flight("B-1002", "MH1006", LocalDateTime.now(ZoneOffset.of("-3")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Shenzhen Bao'an", 60));
        util.add(new Flight("B-1003", "MH1007", LocalDateTime.now(ZoneOffset.of("-2")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Macau", 70));
        util.add(new Flight("B-1003", "MH1008", LocalDateTime.now(ZoneOffset.of("-1")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Changsha Huanghua", 80));
        util.add(new Flight("B-1004", "MH1009", LocalDateTime.now(ZoneOffset.of("+1")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Kunming Wujiaba", 90));
        util.add(new Flight("B-1004", "MH1010", LocalDateTime.now(ZoneOffset.of("+2")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Hangzhou Xiaoshan", 100));
        util.add(new Flight("B-1004", "MH1011", LocalDateTime.now(ZoneOffset.of("+3")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Chongqing Jiangbei", 110));
        util.add(new Flight("B-1004", "MH1012", LocalDateTime.now(ZoneOffset.of("+4")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Hong Kong", 120));
        util.add(new Flight("B-1005", "MH1013", LocalDateTime.now(ZoneOffset.of("+5")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Chengdu Shuangliu", 130));
        util.add(new Flight("B-1006", "MH1014", LocalDateTime.now(ZoneOffset.of("+6")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Shantou Waisha", 140));
        util.add(new Flight("B-1006", "MH1015", LocalDateTime.now(ZoneOffset.of("+7")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Xi'an Xianyang", 150));
        util.add(new Flight("B-1006", "MH1016", LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("EEE LLL dd HH:mm:ss")), "Taiyuan Wusu", "Nanjing Lukou", 160));*/
    }

    @Test
    public void CustomerTest() {
        DataBaseUtil util = new CustomerUtil();
        util.removeAll();
        util.add(new Customer(1, "Chenyang He","140109200010204817","MEN"  ,"18636936796","3535103785@qq.com"));
        util.add(new Customer(2, "Hao Sun"    ,"130178200102295674","MEN"  ,"18647383796","3535103785@qq.com"));
        util.add(new Customer(3, "Yan Sun"    ,"180178200102295674","WOMEN","18662583796","3535103785@qq.com"));
        util.add(new Customer(4, "Zun Xi"     ,"145178200102295674","MEN"  ,"18647383796","3535103785@qq.com"));
        util.add(new Customer(5, "Hong Hua"   ,"340178200102295674","MEN"  ,"18647364796","3535103785@qq.com"));
        util.add(new Customer(6, "Zeng Ze"    ,"640178200102295674","WOMEN","18647438796","3535103785@qq.com"));
        util.add(new Customer(7, "Da Wu"      ,"320178200102295674","MEN"  ,"18634837964","3535103785@qq.com"));
    }

    @Test
    public void OrderTest() {
        DataBaseUtil util = new OrderUtil();
        util.removeAll();
        util.add(new Order("BJEV1RmqVm",1,"MH1001",9, 3, 2));
        util.add(new Order("gCBlsM+AYu",1,"MH1002",11, 1, 1));
        util.add(new Order("aHB9ZlCF9H",2,"MH1004",13, 2, 0));
        util.add(new Order("ekk9mrVMBA",3,"MH1001",9, 1, 1));
        util.add(new Order("80v5pZgbZM",4,"MH1003",17, 3, 1));
        util.add(new Order("c6B9W+hYz6",5,"MH1001",9, 5, 3));
        util.add(new Order("Hg1sAZQCTl",6,"MH1004",13, 4, 0));
        util.add(new Order("d6YRzw6HOs",7,"MH1002",11, 2, 1));
    }

    @Test
    public void BankTest() {
        DataBaseUtil util = new BankUtil();
        util.removeAll();
        util.add(new BankAccount(1, 13579, "Chenyang He", 3200));
        util.add(new BankAccount(2, 24680, "Hao Sun", 1600));
    }
}
