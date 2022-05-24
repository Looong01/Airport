package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel implements Page {
    private final JComboBox<String> comboBox = new JComboBox<>(new String[]{"Card ID", "Order ID"});
    private final JTextField textField = new JTextField();

    public Login() {
        this.setLayout(new GridLayout(3,1));
        JPanel panel = new JPanel(new GridLayout(1,2));

        JLabel label = new JLabel("Group 80 ☀ Kiosk Project", JLabel.CENTER);

        comboBox.addActionListener(e -> {
            Template.getInfoLabel().setText("Please input your " + comboBox.getSelectedItem());
            textField.setText((comboBox.getSelectedIndex() == 0)? "140109200010204817" : "ekk9mrVMBA"); // TODO delete it
        });
        panel.add(comboBox);
        panel.add(textField);

        JButton button = new JButton("Scan QR Code");
        button.addActionListener(e -> {
            System.out.println("clicked");
        });

        this.add(label);
        this.add(panel);
        this.add(button);
        Display.setPageFont(this);
    }

    @Override
    public void syncPage() {
        textField.setText("140109200010204817");
    }

    @Override
    public String getTitle() {
        return "Login";
    }

    @Override
    public String getLabel() {
        return "Please input your Card ID";
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
        // input validation
        if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please input your ID", "Prompt", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        switch (comboBox.getSelectedIndex()) {
            case 0: // cardId
                DAO.setCustomer(SERVICE.loginByCardId(textField.getText()));
                if(DAO.getCustomer() == null)
                    JOptionPane.showMessageDialog(this, "Your card ID is wrong", "Alert", JOptionPane.ERROR_MESSAGE);
                return (DAO.getCustomer() != null);
            case 1: // orderId
                DAO.setOrder(SERVICE.getOrder(textField.getText()));
                if (DAO.getOrder() == null) {
                    JOptionPane.showMessageDialog(this, "Your order ID is wrong", "Alert", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                DAO.setCustomer(SERVICE.getCustomer(DAO.getOrder().getUserId()));
                DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));
                return true;
            default:
                System.err.println("Fatal error");
                return false;
        }
    }
}
