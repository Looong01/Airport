package util.scan;

import entity.user.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

/**
 * Utility class {@code QRCodeService}
 *
 * <p> This class can make QR Code</p>
 *
 * @author Chenyang He
 * @version 2.0
 *
 */
public class QRCodeService {
    /**
     * Generate the Code
     *
     * @param userId the ID of the user
     * @return boolean
     */
    public boolean generateCode(int userId) {
        CustomerService service=new CustomerServiceImpl();
        Customer c=service.getCustomer(userId);
        String destPath = "src/main/resources/jpg/"+userId+".jpg";
        try{
            QRCodeUtil.encode(c.getCardId(), destPath);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}