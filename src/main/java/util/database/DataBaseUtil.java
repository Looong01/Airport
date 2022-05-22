package util.database;

import util.database.entity.*;

/**
 * Utility class {@code AirportUtil}
 *
 * <p> This class will be the prototype of our database,
 * its function will imitate the operation of database.
 * With this class, our data will all project will be
 * correctly used!</>
 *
 * @author Chenyang He; Hao Sun
 * @version 2.0
 *
 */
//该文件内的函数将模拟数据库，通过调用五个util类中的增删改查方法，实现文件的同步更新
//这个文件的函数要区别于service，这里只是对数据库的数据进行修改，并不进行操作，操作全部在service里面实现
public class DataBaseUtil {
    public final FlightUtil fUtil=new FlightUtil();
    public final OrderUtil oUtil=new OrderUtil();
    public final PlaneUtil aUtil=new PlaneUtil();
    public final CustomerUtil cUtil=new CustomerUtil();
    public final StaffUtil sUtil=new StaffUtil();
    public final BankUtil bUtil = new BankUtil();

    /*
      This method will add the customer in the file, and its order
      and flight information will be added in their file

      @param c the customer will be added
      @param orderId the customer's orderId
      @param flightId the flight ID in this customer's order
    //1.该方法是增加customer的时候，将customer的orderId更新，同时根据order中的flightID更新flight

    public void addCustomerWithOrderAndFlight(Customer c, int orderId, int flightId){
        EmailService emailService=new EmailService();

        //先将添加customer的orderId添加到用户自己的order list中
        if(cUtil.findCustomer(c.getUserId())==null){
            cUtil.addCustomer(c);
        }

        //将package信息一并更新
        Random r=new Random(100);
        pUtil.addPackage(new UserPackage(c.getUserId(),r.nextInt(10),r.nextInt(15),r.nextInt(15)));

        //将order同步更新到order文件中,这里的order中的seat和food都在构造方法中默认为未选择
        oUtil.addOrder(new Order(orderId,flightId));

        //将flight同步更新到flight文件中
        //先从机场所有的flight中查到具体信息,然后创建flight对象，将其加入flight文件中
        Flight f = fUtil.findFlight(flightId);
        System.out.println(f.toString());


        AirPort a=aUtil.findPlane(flightId);
        System.out.println(a.toString());
        ArrayList<Integer> cus=new ArrayList<Integer>();cus.add(c.getUserId());
        Flight fTemp=new Flight(flightId, a.getTime(), a.getFromCity(), a.getToCity(), a.getGateId(),cus);
        fUtil.addFlight(fTemp,c.getUserId());

        //将登机牌发送给用户邮箱
        emailService.sendEmail(c.getUserId(), c.getEmail());
    }*/

    /*public void addCustomerWithOrderAndFlightAndPackage(Customer c, int orderId, int flightId,int checkIn,int carryOn){

        //先将添加customer的orderId添加到用户自己的order list中
        cUtil.addCustomer(c);

        //将package同步更新
        pUtil.addPackage(new Package(c.getUserId(),carryOn,checkIn));

        //将order同步更新到order文件中,这里的order中的seat和food都在构造方法中默认为未选择
        oUtil.addOrder(new Order(orderId,flightId));

        //将flight同步更新到flight文件中
        //先从机场所有的flight中查到具体信息,然后创建flight对象，将其加入flight文件中
        AirPort a=aUtil.findFlight(flightId);
        System.out.println(a.toString());
        ArrayList<Integer> cus=new ArrayList<Integer>();cus.add(c.getUserId());
        Flight fTemp=new Flight(flightId, a.getTime(), a.getFromCity(), a.getToCity(), a.getGateId(),cus);
        fUtil.addFlight(fTemp);
    }*/
}
