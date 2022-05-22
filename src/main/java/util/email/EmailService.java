package util.email;

import util.scan.QRCodeService;

public class EmailService {
    public void sendEmail(int userId, String toEmail) {
        //先将二维码生成
        QRCodeService qrService=new QRCodeService();
        qrService.generateCode(userId);

        //封装成邮件发送
        String host = "smtp.qq.com";

        final String username = "2482522606@qq.com"; // use your username
        final String password = "ipzgjrhepslpdhid";
        String from = "2482522606@qq.com";
        String to = toEmail;

        try {
            EmailHelper emailHelper = new EmailHelper(host, username, password, from);
            emailHelper.setTo(to);
            emailHelper.setSubject("领取您的登机牌");
            emailHelper.setHtmlContent("<h1>欢迎使用机场自助值机</h1><br/><h2>您可以使用您的微信扫描二维码获取登机牌</h2><br>");
            emailHelper.setImagePath("src/main/resources/JPG/" + userId + ".jpg");
            emailHelper.sendWithImage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


