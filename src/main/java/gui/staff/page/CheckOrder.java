package gui.staff.page;

import gui.customer.Template;
import gui.staff.Page;

import javax.swing.*;
import java.awt.*;

/**
 * Check order page
 *
 * @author Zelong Li & Shuzhou Zhao
 * @version 1.5
 */
public class CheckOrder extends JPanel implements Page {
	public CheckOrder() {

		this.setLayout(new GridLayout(1, 1)); // 用1*1的网格布局，可以让scrollpane自动适应父元素的大小，不必使用setBounds()
		String[] columnNames = { "Order ID", "Flight ID", "Seat", "Food",
		};
		int a = SERVICE.getOrderNum();
		Object[][] obj = new Object[SERVICE.getOrderNum()][4];
		JTable table = new JTable(obj, columnNames);
		table.setEnabled(false);

		// 表头和内容的字体大小要分别设置
		table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
		table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 必须禁止table自适应大小，不然table默认会适应scrollpane的宽度，就用不了滚动条了
		
		int columnwidth = (int) (900 * Template.getP())/(table.getColumnCount() + 1);

		table.getColumnModel().getColumn(0).setPreferredWidth((int) (225 * Template.getP()));
		table.getColumnModel().getColumn(1).setPreferredWidth((int) (174 * Template.getP()));
		table.getColumnModel().getColumn(2).setPreferredWidth((int) (174 * Template.getP()));
		table.getColumnModel().getColumn(3).setPreferredWidth((int) (325 * Template.getP()));

		table.setRowHeight((int) (530 * Template.getP() / table.getRowCount())); // 这里指定表格的行高，600P是容器高度，用行数来平均分，+1算入了表头行

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		String[] flightIds = SERVICE.getFlightId();
		String[] orderIds = SERVICE.getOrderId();
		String[] seats = SERVICE.getSeat();
		String[] foods = SERVICE.getFood();

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < 4; j++) {
				switch (j) {
					case 0:
						obj[i][j] = orderIds[i];
						break;
					case 1:
						obj[i][j] = flightIds[i];
						break;
					case 2:
						obj[i][j] = seats[i];
						break;
					case 3:
						obj[i][j] = foods[i];
						break;
				}
			}

		}

		this.add(scrollPane);
	}

	@Override
	public String getTitle() {
		return "Order Information";
	}

	@Override
	public String getLabel() {
		return "Here is Order information";
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
