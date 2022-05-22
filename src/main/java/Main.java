import gui.customer.CustomerGUI;
import gui.staff.StaffGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Entry point for the whole project, provide options to choose CUSTOMER / STAFF
 * @author wzy
 * @version 3.0
 */
public class Main extends JFrame {


	public Main() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setTitle("Kiosk Project Group 79");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));

		JButton button1 = new JButton("Customer");
		JButton button2 = new JButton("Staff");
		button1.setFont(new Font("", Font.ITALIC, 90));
		button2.setFont(new Font("", Font.ITALIC, 90));

		button1.addActionListener(e -> {
			CustomerGUI.getWindow().setVisible(true);
			this.dispose();
		});

		button2.addActionListener(e -> {
			StaffGUI.getWindow().setVisible(true);
			this.dispose();
		});

		this.add(button1);
		this.add(button2);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Main gui = new Main();
		gui.setVisible(true);
	}
}
