package util.email;

import util.scan.QRCodeService;

public class EmailService {
    public void sendEmail(int userId, String toEmail) {
        QRCodeService qrService=new QRCodeService();
        qrService.generateCode(userId);

        String host = "smtp.qq.com";

        final String username = "2482522606@qq.com"; // use your username
        final String password = "ipzgjrhepslpdhid";
        String from = "2482522606@qq.com";

        try {
            EmailHelper emailHelper = new EmailHelper(host, username, password, from);
            emailHelper.setTo(toEmail);
            emailHelper.setSubject("Get your boarding pass");
            emailHelper.setHtmlContent("<h1>Welcome to the airport self-service check-in</h1><br/><h2>You can use your wechat scanning QR code to get your boarding pass</h2><br>");
            emailHelper.setImagePath("src/main/resources/jpg/" + userId + ".jpg");
            emailHelper.sendWithImage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


