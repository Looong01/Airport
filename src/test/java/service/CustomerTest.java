package service;

import entity.user.Customer;
import org.junit.jupiter.api.Test;
import service.impl.CustomerServiceImpl;
import util.database.DataBaseUtil;
import util.scan.PythonPhoto;
import util.scan.QRCodeService;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerTest {
    DataBaseUtil util=new DataBaseUtil();

    /*@Test
    public void scanDataTest(){
        Customer c1=new Customer(19, "Chenyang He","140109200010204817","MEN"  ,"18636936796",new ArrayList<Integer>(Arrays.asList(18)),"3535103785@qq.com");
        util.addCustomerWithOrderAndFlight(c1,12,1);
    }*/

    @Test
    public void scanPhotoTest(){
        PythonPhoto pythonPhoto=new PythonPhoto();
        pythonPhoto.takePhoto("19");
    }

    @Test
    public void analyseDataTest(){
        QRCodeService service=new QRCodeService();
        //service.generateCode(4);
        String cardId=service.analyseCode(19);
        System.out.println(cardId);
    }

}

