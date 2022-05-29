package gui.staff.page;

import gui.staff.Page;
import util.gui.Display;

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

    public Login() {
        
        this.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel("Enter Card ID:   ");
        JLabel label2 = new JLabel("Enter password:   ");

        
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        this.add(label1, gbc1);
        
        textField.setPreferredSize(new Dimension(350, 70));
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        this.add(textField, gbc2);

       
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        this.add(label2, gbc3);
        passwordField.setPreferredSize(new Dimension(350, 70));
        label2.setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 0));
        
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 1;
        gbc4.gridy = 1;
        this.add(passwordField, gbc4);

        Display.setPanelFont(this);
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
            JOptionPane.showMessageDialog(this, "Login successfully", "Prompt",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(this, "Login failed", "Prompt",
                    JOptionPane.INFORMATION_MESSAGE);

        return false;
    }

    @Override
    public void syncPage() {

    }
}
