package gui.customer.page;

import gui.customer.Page;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ChooseOrder extends JPanel implements Page {
	private final JTextArea textArea;
	private final JComboBox<String> comboBox;

	public ChooseOrder() {
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
		ArrayList<Integer> orders = DAO.getCustomer().getOrder();
		textArea.setText("");
		comboBox.removeAllItems();
		comboBox.addItem("Choose order");
		for (Integer order : orders) {
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
		return "Please choose an order to proceed";
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
		if (comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Please choose your order", "Prompt", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		DAO.setOrder(SERVICE.getOrder(Integer.parseInt((String) Objects.requireNonNull(comboBox.getSelectedItem()))));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));
		return true;
	}
}
