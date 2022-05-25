package gui.staff.page;

import gui.staff.Page;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;

/**
 * 直接使用local variable，实现ArrayList<JPanel>，下同
 */
public class Login extends JPanel implements Page {
    // 添加两个文本输入框，并加入this
    public JTextField textField = new JTextField("140109200010204817");

    public JPasswordField passwordField = new JPasswordField("123456");

    public Login() {
        // 设置布局为gridBagLayout
        this.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel("Enter Card ID:   ");
        JLabel label2 = new JLabel("Enter password:   ");

        // 将label1放在第一行第一列
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        this.add(label1, gbc1);
        // 设置textfield的高度
        textField.setPreferredSize(new Dimension(350, 70));
        // 将textField放在第一行第二列
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        this.add(textField, gbc2);

        // 将label2放在第二行第一列
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        this.add(label2, gbc3);
        passwordField.setPreferredSize(new Dimension(350, 70));
        label2.setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 0));
        // 将passwordField放在第二行第二列
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 1;
        gbc4.gridy = 1;
        this.add(passwordField, gbc4);

        Display.setPageFont(this);
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
