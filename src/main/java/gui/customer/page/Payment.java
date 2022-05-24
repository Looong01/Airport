package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;

public class Payment extends JPanel implements Page {
	private final JTextField textField1 = new JTextField();
	private final JTextField textField2 = new JTextField();
	private final JTextField textField3 = new JTextField();

	public Payment() {
		this.setLayout(new GridLayout(3, 2));
		// cardId, name, tel
		this.add(new JLabel("Name"));
		this.add(textField1);
		this.add(new JLabel("Card ID"));
		this.add(textField2);
		this.add(new JLabel("Tel"));
		this.add(textField3);
		Display.setPageFont(this);
	}

	@Override
	public void syncPage() {
		Template.getCont().setText("Pay $" + DAO.getDue());
		textField1.setText("User A");
		textField2.setText("13579");
		textField3.setText("12345678901");
	}

	@Override
	public String getTitle() {
		return "Payment";
	}

	@Override
	public String getLabel() {
		return "Please input your credit card ID to pay";
	}

	@Override
	public boolean back() {
		return true;
	}

	@Override
	public boolean cont() {
		if (BANK.pay(Integer.parseInt(textField2.getText()), DAO.getDue())) {
			JOptionPane.showMessageDialog(this, "Payment successful", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			// write CustomerDAO into json
			return SERVICE.chooseSeat(DAO.getOrder()) && SERVICE.chooseFood(DAO.getOrder());
		}
		JOptionPane.showMessageDialog(this, "Payment error! Please recheck your card ID", "Warning", JOptionPane.ERROR_MESSAGE);
		return false;
	}
}
