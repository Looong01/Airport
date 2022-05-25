package gui.customer.page;

import entity.Flight;
import entity.Order;
import gui.customer.Page;
import gui.customer.Template;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewOrder extends JPanel implements Page {
	private final JTextArea textArea;
	private final JComboBox<String> comboBox;

	public ReviewOrder() {
		this.setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane, BorderLayout.CENTER);
		comboBox = new JComboBox<>();
		this.add(comboBox, BorderLayout.SOUTH);
		Display.setPageFont(this);
		textArea.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (30 * Template.getP())));
	}

	@Override
	public void syncPage() {
		if (!DAO.isCardLogin()) {
			Flight flight = SERVICE.getFlight(DAO.getOrder().getFlightId());
			textArea.setText("> Order " + DAO.getOrder().getOrderId() + "\n");
			if (DAO.getOrder().getStatus().equals("C")) {
				textArea.append("Status: " + "Checking in" + "\n");
				textArea.append("To: " + flight.getToCity() + "\n");
				textArea.append("Time: " + flight.getTime() + "\n");
			} else {
				textArea.append("Status: " + "Awaiting boarding" + "\n");
				textArea.append("To: " + flight.getToCity() + "\n");
				textArea.append("Time: " + flight.getTime() + "\n");
				textArea.append("Seat: " + DAO.getOrder().getSeatId() + "\n");
				textArea.append("Food: " + DAO.getOrder().getFood() + "\n");
			}

			// hide comboBox
			comboBox.setVisible(false);
		} else {
			ArrayList<String> orders = DAO.getCustomer().getOrders();
			textArea.setText("");
			comboBox.removeAllItems();
			comboBox.addItem("Choose an order");
			for (String o : orders) {
				Order order = SERVICE.getOrder(o);
				Flight flight = SERVICE.getFlight(order.getFlightId());

				textArea.append("> Order " + order.getOrderId() + "\n");
				if (order.getStatus().equals("C")) {
					textArea.append("Status: " + "Checking in" + "\n");
					textArea.append("To: " + flight.getToCity() + "\n");
					textArea.append("Time: " + flight.getTime() + "\n\n");
				} else {
					textArea.append("Status: " + "Awaiting boarding" + "\n");
					textArea.append("To: " + flight.getToCity() + "\n");
					textArea.append("Time: " + flight.getTime() + "\n");
					textArea.append("Seat: " + order.getSeatId() + "\n");
					textArea.append("Food: " + order.getFood() + "\n\n");
				}
				comboBox.addItem(o);
			}
			comboBox.setVisible(true);
		}
		this.repaint();
	}

	@Override
	public String getTitle() {
		return "Flight Info";
	}

	@Override
	public String getLabel() {
		return (DAO.isCardLogin())? "Please choose an order to proceed": "Please review your order to proceed";
	}

	public String getCont() {
		return "CONFIRM";
	}

	@Override
	public boolean back() {
		if (JOptionPane.showConfirmDialog(this, "Logout now?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			DAO.reset();
			return true;
		}
		return false;
	}

	@Override
	public boolean cont() {
		if (!DAO.isCardLogin())
			return DAO.getOrder().getStatus().equals("C");

		if (comboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Please choose your order", "Prompt", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		DAO.setOrder(SERVICE.getOrder((String) Objects.requireNonNull(comboBox.getSelectedItem())));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));
		return DAO.getOrder().getStatus().equals("C");
	}
}
