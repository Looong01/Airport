import gui.customer.CustomerGUI;
import gui.staff.StaffGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Entry point for the whole project, provide options to choose CUSTOMER / STAFF
 * 
 * @author Ziyao Wang
 * @author Zelong Li
 * @version 1.6
 */
public class Main extends JFrame {
	/**
	 * constructor for main method
	 */
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
		button1.setFont(new Font(Font.SERIF, Font.ITALIC, 100));
		button2.setFont(new Font(Font.SERIF, Font.ITALIC, 100));
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
		this.setSize(600,450);
		this.setLocationRelativeTo(null);
	}

	/**
	 * main method
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		Main gui = new Main();
		gui.setVisible(true);
	}
}