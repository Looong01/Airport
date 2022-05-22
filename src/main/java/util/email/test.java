package util.email;

import org.junit.Test;

public class test {
    @Test
    public void testEmail(){
        EmailService service=new EmailService();
        service.sendEmail(1,"3535103785@qq.com");
    }
}
