package gui.customer.page;

import gui.customer.Page;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;

/**
 * 直接使用local variable，实现ArrayList<JPanel>，下同
 */
public class Login extends JPanel implements Page {
    private final JTextField textField1 = new JTextField();
    private final JTextField textField2 = new JTextField();
    private final JTextField textField3 = new JTextField();

    public Login() {
        this.setLayout(new GridLayout(3,2));
        this.add(new JLabel("Booking Number"));
        this.add(textField1);
        this.add(new JLabel("Card ID"));
        this.add(textField2);
        this.add(new JLabel("ID Codes"));
        this.add(textField3);
        Display.setPageFont(this);
    }

    @Override
    public void syncPage() {
        textField2.setText("140109200010204817");
    }

    @Override
    public String getTitle() {
        return "Login";
    }

    @Override
    public String getLabel() {
        return "Please input your card ID";
    }

    @Override
    public String getCont() {
        return "Login";
    }

    @Override
    public boolean back() {
        return true;
    }

    @Override
    public boolean cont() {
        //目前只有检验CardID的功能
        DAO.setCustomer(SERVICE.LoginByCardId(textField2.getText()));
        if(DAO.getCustomer() == null)
            JOptionPane.showMessageDialog(this, "Your card ID is wrong", "alert", JOptionPane.ERROR_MESSAGE);

        return (DAO.getCustomer() != null);
    }
}
