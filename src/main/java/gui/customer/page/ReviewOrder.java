package gui.customer.page;

import gui.customer.Page;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewOrder extends JPanel implements Page {
	private final JTextArea textArea;
	private final JComboBox<String> comboBox;

	public ReviewOrder() {
		this.setLayout(new GridLayout(2, 1));
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		this.add(textArea);
		comboBox = new JComboBox<>();
		this.add(comboBox);
		Display.setPageFont(this);
	}

	@Override
	public void syncPage() {
		ArrayList<String> orders = DAO.getCustomer().getOrders();
		textArea.setText("");
		comboBox.removeAllItems();
		comboBox.addItem("Choose order");
		for (String order : orders) {
			textArea.append(SERVICE.getOrder(order) + "\n");
			comboBox.addItem("" + order);
		}
	}

	@Override
	public String getTitle() {
		return "Flight Info";
	}

	@Override
	public String getLabel() {
		return (DAO.getOrder() == null)? "Please choose an order to proceed": "Please review your order";
	}

	public String getCont() {
		return "Confirm";
	}

	@Override
	public boolean back() {
		return JOptionPane.showConfirmDialog(this, "Logout now?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	@Override
	public boolean cont() {
		if (DAO.getOrder() != null)
			return true;

		if (comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Please choose your order", "Prompt", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		DAO.setOrder(SERVICE.getOrder((String) Objects.requireNonNull(comboBox.getSelectedItem())));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));
		return true;
	}
}
