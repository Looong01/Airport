package util.scan;

import entity.user.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

public class QRCodeService {

    public boolean generateCode(int userId){
        CustomerService service=new CustomerServiceImpl();
        //String card=service.printCard(cardId);
        //System.out.println(card);
        Customer c=service.getCustomer(userId);
        // 嵌入二维码的图片路径
        String imgPath = "src/main/jpg/"+userId;
        // 生成的二维码的路径及名称
        String destPath = "src/main/resources/jpg/"+userId+".jpg";
        try{
            //生成二维码
            QRCodeUtil.encode(c.getCardId(), imgPath,destPath, true);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String analyseCode(int userId){
        String str="";
        // 生成的二维码的路径及名称
        String destPath = "src/main/resources/jpg/"+userId+".jpg";
        try{
            // 解析二维码
            str = QRCodeUtil.decode(destPath);
            // 打印出解析出的内容
            //System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
