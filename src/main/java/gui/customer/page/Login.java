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
        this.setLayout(new GridLayout(2,1));
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1,2));

        JLabel label = new JLabel("Group 80 ☀ Kiosk Project", JLabel.CENTER);

        comboBox.addActionListener(e -> {
            Template.getInfoLabel().setText("Please input your " + comboBox.getSelectedItem());
            textField.setText((comboBox.getSelectedIndex() == 0)? "140109200010204817" : "BJEV1RmqVm"); // TODO delete it
        });
        inputPanel.add(comboBox);
        inputPanel.add(textField);

        JButton button = new JButton("Scan QR Code");
        button.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "1. Your computer must have a camera.\n2. The scanner won't terminate unless QR code is identified.", "Requirements", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DAO.setCustomer(SERVICE.loginByScanId());
                Template.getCont().doClick();
            }
        });

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        this.add(label);
        this.add(panel);
        Display.setPanelFont(this, 40);
        label.setFont(new Font(Font.SERIF, Font.ITALIC, (int) (70 * Template.getP())));
    }

    @Override
    public void syncPage() {
        comboBox.setSelectedIndex(0);
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
        return "LOGIN";
    }

    @Override
    public boolean back() {
        return true;
    }

    @Override
    public boolean cont() {
        // scan login
        if (DAO.getCustomer() != null)
            return true;

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
                DAO.setCardLogin(false);
                return true;
            default:
                System.err.println("Fatal error");
                return false;
        }
    }
}
