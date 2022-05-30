package gui.staff.page;

import gui.staff.Template;
import gui.staff.Page;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
import java.awt.*;

/**
 * Login page
 *
 * @author Zelong Li
 * @author Shuzhou Zhao
 * @version 1.5
 */
public class Login extends JPanel implements Page {
    private final JTextField textField = new JTextField("140109200010204817");
    private final JPasswordField passwordField = new JPasswordField("123456");
    //constructor for login
    public Login() {
        // GridBagLayout layout = new GridBagLayout();
        // GridBagLayoutConstraints constraints = new GridBagLayoutConstraints();
        // this.setLayout(layout);
        this.setLayout(null);
        JLabel label1 = new JLabel("Card ID: ");
        JLabel label2 = new JLabel("Password: ");
        label1.setBounds((int) (150 * Template.getP()), (int) (150 * Template.getP()), (int) (400 * Template.getP()), (int) (100 * Template.getP()));
        label2.setBounds((int) (150 * Template.getP()), (int) (350 * Template.getP()), (int) (400 * Template.getP()), (int) (100 * Template.getP()));
        textField.setBounds((int) (350 * Template.getP()), (int) (150 * Template.getP()), (int) (400 * Template.getP()), (int) (100 * Template.getP()));
        passwordField.setBounds((int) (350 * Template.getP()), (int) (350 * Template.getP()), (int) (400 * Template.getP()), (int) (100 * Template.getP()));
        // constraints.setConstraints(0,0,1,1);
        // layout.setConstraints(label1, constraints);
        // constraints.setConstraints(1,0,2,1);
        // layout.setConstraints(textField, constraints);
        // constraints.setConstraints(0,1,1,1);
        // layout.setConstraints(label2, constraints);
        // constraints.setConstraints(1,1,3,1);
        // layout.setConstraints(passwordField, constraints);
        this.add(label1);
        this.add(textField);
        this.add(label2);
        this.add(passwordField);
        Display.setPanelFont(this, 35);
    }

    @Override
    public String getTitle() {
        return "Login";
    }

    @Override
    public String getLabel() {
        return "Welcome to Staff System!";
    }

    @Override
    public boolean back() {
        return true;
    }

    @Override
    public boolean cont() {
        String cardId = textField.getText();
        String password = new String(passwordField.getPassword());
        boolean TorF = SERVICE.loginByPasswd(cardId, password);
        if (TorF) {
            JOptionPane.showMessageDialog(this, "Login successfully", "Prompt", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(this, "Wrong Card ID or Password", "Prompt", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    @Override
    public void syncPage() {

    }
}