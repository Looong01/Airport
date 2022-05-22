package util.email;

import org.junit.jupiter.api.Test;

public class emailTest {
    @Test
    public void test(){
        EmailService service=new EmailService();
        service.sendEmail(1,"3535103785@qq.com");
    }
}
