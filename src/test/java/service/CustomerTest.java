package service;

import org.junit.jupiter.api.Test;
import service.impl.CustomerServiceImpl;
import util.scan.PythonPhoto;

public class CustomerTest {
    CustomerService service=new CustomerServiceImpl();

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

    @Test
    public void logInByScan(){
        //service.LoginByScanId();
        System.out.println(service.LoginByScanId());
    }


}

