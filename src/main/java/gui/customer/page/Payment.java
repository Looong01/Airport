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
		this.add(new JLabel("Full Name"));
		this.add(textField1);
		this.add(new JLabel("Credit Card"));
		this.add(textField2);
		this.add(new JLabel("Telephone"));
		this.add(textField3);
		Display.setPageFont(this, 50);
	}

	@Override
	public void syncPage() {
		Template.getCont().setText("PAY $" + (DAO.getSeatDue() + DAO.getFoodDue()));
		textField1.setText("Chenyang He");
		textField2.setText("13579");
		textField3.setText("18636936796"); // TODO delete it
	}

	@Override
	public String getTitle() {
		return "Payment";
	}

	@Override
	public String getLabel() {
		return "Please input your payment information";
	}

	@Override
	public boolean back() {
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		return true;
	}

	@Override
	public boolean cont() {
		if (JOptionPane.showConfirmDialog(this, "Confirm your option?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (BANK.pay(Integer.parseInt(textField2.getText()), DAO.getSeatDue() + DAO.getFoodDue())) {
				JOptionPane.showMessageDialog(this, "Payment successful", "Prompt", JOptionPane.INFORMATION_MESSAGE);
				// write CustomerDAO into json
				return SERVICE.chooseSeat(DAO.getOrder()) && SERVICE.chooseFood(DAO.getOrder());
			}
			JOptionPane.showMessageDialog(this, "Payment error! Please recheck your card ID", "Warning", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
}
