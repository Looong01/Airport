package util.database;

import entity.*;
import entity.user.*;
import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * Test class for generation of Plane.json, Staff.json, Flight.json, Customer.json, Order.json, and Bank.json
 *
 * @author Chenyang He
 * @author Ziyao Wang
 * @version 5.0
 */
public class DatabaseTest {
    DataBaseUtil util = new DataBaseUtil();

    // 注意！运行前必须先清空json文件夹!

    @Test
    public void PlaneTest() {
        util.aUtil.addPlane(new Plane(1001));
        util.aUtil.addPlane(new Plane(1002));
        util.aUtil.addPlane(new Plane(1003));
        util.aUtil.addPlane(new Plane(1004));
        util.aUtil.addPlane(new Plane(1005));
        util.aUtil.addPlane(new Plane(1006));
    }

    @Test
    public void StaffTest(){
        util.sUtil.addStaff(new Staff(1,"Chenyang He","140109200010204817", "123456"));
        util.sUtil.addStaff(new Staff(2,"Hao Sun","130178200102295674","qwerty"));
    }

    @Test
    public void FlightTest() {
        util.fUtil.addFlight(new Flight(1001, 1, (new Date()).toString(), "Taiyuan Wusu", "Beijing Capital", 10));
        util.fUtil.addFlight(new Flight(1001, 2, (new Date()).toString(), "Taiyuan Wusu","Shanghai Pudong", 20));
        util.fUtil.addFlight(new Flight(1002, 3, (new Date()).toString(), "Taiyuan Wusu", "Beijing Daxing", 30));
        util.fUtil.addFlight(new Flight(1002, 4, (new Date()).toString(), "Taiyuan Wusu", "Guangzhou Baiyun", 40));
        util.fUtil.addFlight(new Flight(1002, 5, (new Date()).toString(), "Taiyuan Wusu", "Shanghai Hongqiao", 50));
        util.fUtil.addFlight(new Flight(1002, 6, (new Date()).toString(), "Taiyuan Wusu", "Shenzhen Bao'an", 60));
        util.fUtil.addFlight(new Flight(1003, 7, (new Date()).toString(), "Taiyuan Wusu", "Macau", 70));
        util.fUtil.addFlight(new Flight(1003, 8, (new Date()).toString(), "Taiyuan Wusu", "Changsha Huanghua", 80));
        util.fUtil.addFlight(new Flight(1004, 9, (new Date()).toString(), "Taiyuan Wusu", "Kunming Wujiaba", 90));
        util.fUtil.addFlight(new Flight(1004, 10, (new Date()).toString(), "Taiyuan Wusu", "Hangzhou Xiaoshan", 100));
        util.fUtil.addFlight(new Flight(1004, 11, (new Date()).toString(), "Taiyuan Wusu", "Chongqing Jiangbei", 110));
        util.fUtil.addFlight(new Flight(1004, 12, (new Date()).toString(), "Taiyuan Wusu", "Hong Kong", 120));
        util.fUtil.addFlight(new Flight(1005, 13, (new Date()).toString(), "Taiyuan Wusu", "Chengdu Shuangliu", 130));
        util.fUtil.addFlight(new Flight(1006, 14, (new Date()).toString(), "Taiyuan Wusu", "Shantou Waisha", 140));
        util.fUtil.addFlight(new Flight(1006, 15, (new Date()).toString(), "Taiyuan Wusu", "Xi'an Xianyang", 150));
        util.fUtil.addFlight(new Flight(1006, 16, (new Date()).toString(), "Taiyuan Wusu", "Nanjing Lukou", 160));
    }

    @Test
    public void CustomerTest(){
        util.cUtil.addCustomer(new Customer(1, "Chenyang He","140109200010204817","MEN"  ,"18636936796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(2, "Hao Sun"    ,"130178200102295674","MEN"  ,"18647383796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(3, "Yan Sun"    ,"180178200102295674","WOMEN","18662583796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(4, "Zun Xi"     ,"145178200102295674","MEN"  ,"18647383796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(5, "Hong Hua"   ,"340178200102295674","MEN"  ,"18647364796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(6, "Zeng Ze"    ,"640178200102295674","WOMEN","18647438796","3535103785@qq.com"));
        util.cUtil.addCustomer(new Customer(7, "Da Wu"      ,"320178200102295674","MEN"  ,"18634837964","3535103785@qq.com"));

        /*Customer c1=new Customer(1, "Chenyang He","140109200010204817","MEN"  ,"18636936796",new ArrayList<Integer>(Arrays.asList(1,2)),"3535103785@qq.com");
        Customer c2=new Customer(2, "Hao Sun"    ,"130178200102295674","MEN"  ,"18647383796",new ArrayList<Integer>(Arrays.asList(3)),"3535103785@qq.com");
        Customer c3=new Customer(3, "Yan Sun"    ,"180178200102295674","WOMEN","18662583796",new ArrayList<Integer>(Arrays.asList(4)),"3535103785@qq.com");
        Customer c4=new Customer(4, "Zun Xi"     ,"145178200102295674","MEN"  ,"18647383796",new ArrayList<Integer>(Arrays.asList(5)),"3535103785@qq.com");
        Customer c5=new Customer(5, "Hong Hua"   ,"340178200102295674","MEN"  ,"18647364796",new ArrayList<Integer>(Arrays.asList(6)),"3535103785@qq.com");
        Customer c6=new Customer(6, "Zeng Ze"    ,"640178200102295674","WOMEN","18647438796",new ArrayList<Integer>(Arrays.asList(7)),"3535103785@qq.com");
        Customer c7=new Customer(7, "Da Wu"      ,"320178200102295674","MEN"  ,"18634837964",new ArrayList<Integer>(Arrays.asList(8)),"3535103785@qq.com");

        util.addCustomerWithOrderAndFlight(c1,1,1);
        util.addCustomerWithOrderAndFlight(c1,2,2);
        util.addCustomerWithOrderAndFlight(c2,3,14);
        util.addCustomerWithOrderAndFlight(c3,4,1);
        util.addCustomerWithOrderAndFlight(c4,5,12);
        util.addCustomerWithOrderAndFlight(c5,6,2);
        util.addCustomerWithOrderAndFlight(c6,7,4);
        util.addCustomerWithOrderAndFlight(c7,8,7);*/
    }

    @Test
    public void OrderTest() {
        util.oUtil.addOrder(new Order(1000111,1,1,9, 3, 2));
        util.oUtil.addOrder(new Order(1000222,1,2,11, 1, 0));
        util.oUtil.addOrder(new Order(1000333,2,14,13, 2, 0));
        util.oUtil.addOrder(new Order(1000444,3,1,15, 1, 1));
        util.oUtil.addOrder(new Order(1000555,4,12,17, 3, 1));
        util.oUtil.addOrder(new Order(1000666,5,2,19, 5, 3));
        util.oUtil.addOrder(new Order(1000777,6,4,21, 4, 0));
        util.oUtil.addOrder(new Order(1000888,7,7,23, 2, 1));
    }

    @Test
    public void BankTest() {
        util.bUtil.addAccount(new BankAccount(1, 13579, "Chenyang He", 3200));
        util.bUtil.addAccount(new BankAccount(2, 24680, "Hao Sun", 428972));
        util.bUtil.addAccount(new BankAccount(2, 88888, "Hao Sun 2", 42));
    }

    /*@Test
    public void EmailTest() {
        EmailService emailService=new EmailService();
        //将登机牌发送给用户邮箱
        emailService.sendEmail(c.getUserId(), c.getEmail());
    }*/

    /*@Test
    public void AirplaneTest() {
        String[] City={"Beijing Capital International Airport","Shanghai Pudong International Airport","Beijing Daxing International Airport",
                "Guangzhou Baiyun International Airport","Shanghai Hongqiao International Airport","Shenzhen Bao'an International Airport","Macau International Airport",
                "Changsha Huanghua International Airport","Kunming Wujiaba International Airport","Hangzhou Xiaoshan International Airport","Chongqing Jiangbei International Airport",
                "Hong Kong International Kai Tak Airport","Chengdu Shuangliu International Airport","Shantou Waisha Airport","Xi'an Xianyang International Airport","Nanjing Lukou Airport"};

        for(int i=1;i<=City.length;i++) {
            AirPort a=new AirPort(i, new Date().toString(),"Taiyuan Wusu Airport", City[i-1],i);
            util.addPlaneInfo(a);
        }
    }*/
}
