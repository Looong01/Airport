package util.email;

import org.junit.jupiter.api.Test;

public class EmailTest {
    @Test
    public void test() {
        EmailService service = new EmailService();
        service.sendEmail(1,"wangziyao318@163.com"); // for wangziyao test
    }
}
