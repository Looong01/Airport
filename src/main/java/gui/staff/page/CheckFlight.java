package gui.staff.page;

import gui.staff.Template;
import gui.staff.Page;

import javax.swing.*;
import java.awt.*;

/**
 * Check flight page
 *
 * @author Zelong Li
 * @author Shuzhou Zhao
 * @version 1.5
 */
public class CheckFlight extends JPanel implements Page {
	/**
	 * constructor for check flight
	 */
	public CheckFlight() {
		this.setLayout(null);
		String[] columnNames = { "The flight ID", "The gate ID", "From which city", "The time of taking off", "To which city" };
		String[] idInt = SERVICE.getFlightIds();
		Object[][] obj = new Object[idInt.length][5];
		JTable table = new JTable(obj, columnNames);
		table.setEnabled(false);
		table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
		table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth((int) (200 * Template.getP()));
		table.getColumnModel().getColumn(1).setPreferredWidth((int) (200 * Template.getP()));
		table.getColumnModel().getColumn(2).setPreferredWidth((int) (350 * Template.getP()));
		table.getColumnModel().getColumn(3).setPreferredWidth((int) (450 * Template.getP()));
		table.getColumnModel().getColumn(4).setPreferredWidth((int) (550 * Template.getP()));
		table.setRowHeight((int) (530 * Template.getP() / (table.getRowCount())));
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, (int) (900 * Template.getP()), (int) (600 * Template.getP()));
		for (int i = 0; i < idInt.length; i++) {
			for (int j = 0; j < 5; j++) {
				switch (j) {
					case 0:
						obj[i][j] = String.valueOf(idInt[i]);
						break;
					case 1:
						obj[i][j] = String.valueOf(SERVICE.getGateId(idInt[i]));
						break;
					case 2:
						obj[i][j] = SERVICE.getFromCity(idInt[i]);
						break;
					case 3:
						obj[i][j] = SERVICE.getTime(idInt[i]);
						break;
					case 4:
						obj[i][j] = SERVICE.getToCity(idInt[i]);
						break;
				}
			}
		}
		this.add(scrollPane);
	}

	@Override
	public String getTitle() {
		return "Flight Information";
	}

	@Override
	public String getLabel() {
		return "Here is Flight information";
	}

	@Override
	public boolean back() {
		return true;
	}

	@Override
	public boolean cont() {
		return true;
	}

	@Override
	public void syncPage() {

	}
}