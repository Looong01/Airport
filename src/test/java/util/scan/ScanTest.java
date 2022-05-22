package util.scan;

import org.junit.jupiter.api.Test;

public class ScanTest {
    @Test
    public void test(){
        QRCodeService service=new QRCodeService();
        //service.generateCode(4);
        service.analyseCode(1);

    }

    @Test
    public void generateCode(){

        String infor="https://zhidao.baidu.com/question/372282253212494124.html";
        // 嵌入二维码的图片路径
        String imgPath = "src/main/JPG/test";
        // 生成的二维码的路径及名称
        String destPath = "src/main/resources/JPG/test.jpg";
        try{
            //生成二维码
            QRCodeUtil.encode(infor, imgPath,destPath, true);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
