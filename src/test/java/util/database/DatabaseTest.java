package util.database;

import entity.*;
import entity.user.*;
import org.junit.jupiter.api.Test;
import util.database.entity.*;

import java.util.*;


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
        util.add(new Plane(1001));
        util.add(new Plane(1002));
        util.add(new Plane(1003));
        util.add(new Plane(1004));
        util.add(new Plane(1005));
        util.add(new Plane(1006));
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
        util.add(new Flight(1001, 1, (new Date()).toString(), "Taiyuan Wusu", "Beijing Capital", 10));
        util.add(new Flight(1001, 2, (new Date()).toString(), "Taiyuan Wusu","Shanghai Pudong", 20));
        util.add(new Flight(1002, 3, (new Date()).toString(), "Taiyuan Wusu", "Beijing Daxing", 30));
        util.add(new Flight(1002, 4, (new Date()).toString(), "Taiyuan Wusu", "Guangzhou Baiyun", 40));
        util.add(new Flight(1002, 5, (new Date()).toString(), "Taiyuan Wusu", "Shanghai Hongqiao", 50));
        util.add(new Flight(1002, 6, (new Date()).toString(), "Taiyuan Wusu", "Shenzhen Bao'an", 60));
        util.add(new Flight(1003, 7, (new Date()).toString(), "Taiyuan Wusu", "Macau", 70));
        util.add(new Flight(1003, 8, (new Date()).toString(), "Taiyuan Wusu", "Changsha Huanghua", 80));
        util.add(new Flight(1004, 9, (new Date()).toString(), "Taiyuan Wusu", "Kunming Wujiaba", 90));
        util.add(new Flight(1004, 10, (new Date()).toString(), "Taiyuan Wusu", "Hangzhou Xiaoshan", 100));
        util.add(new Flight(1004, 11, (new Date()).toString(), "Taiyuan Wusu", "Chongqing Jiangbei", 110));
        util.add(new Flight(1004, 12, (new Date()).toString(), "Taiyuan Wusu", "Hong Kong", 120));
        util.add(new Flight(1005, 13, (new Date()).toString(), "Taiyuan Wusu", "Chengdu Shuangliu", 130));
        util.add(new Flight(1006, 14, (new Date()).toString(), "Taiyuan Wusu", "Shantou Waisha", 140));
        util.add(new Flight(1006, 15, (new Date()).toString(), "Taiyuan Wusu", "Xi'an Xianyang", 150));
        util.add(new Flight(1006, 16, (new Date()).toString(), "Taiyuan Wusu", "Nanjing Lukou", 160));
    }

    @Test
    public void CustomerTest(){
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
        util.add(new Order(1000111,1,1,9, 3, 2));
        util.add(new Order(1000222,1,2,11, 1, 0));
        util.add(new Order(1000333,2,14,13, 2, 0));
        util.add(new Order(1000444,3,1,15, 1, 1));
        util.add(new Order(1000555,4,12,17, 3, 1));
        util.add(new Order(1000666,5,2,19, 5, 3));
        util.add(new Order(1000777,6,4,21, 4, 0));
        util.add(new Order(1000888,7,7,23, 2, 1));
    }

    @Test
    public void BankTest() {
        DataBaseUtil util = new BankUtil();
        util.removeAll();
        util.add(new BankAccount(1, 13579, "Chenyang He", 3200));
        util.add(new BankAccount(2, 24680, "Hao Sun", 428972));
        util.add(new BankAccount(2, 88888, "Hao Sun 2", 42));
    }

    /*@Test
    public void EmailTest() {
        EmailService emailService=new EmailService();
        //将登机牌发送给用户邮箱
        emailService.sendEmail(c.getUserId(), c.getEmail());
    }*/
}
