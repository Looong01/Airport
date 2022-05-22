package gui.staff.page;

import gui.customer.Template;
import gui.staff.dao.DAO;
import gui.staff.Page;

import javax.swing.*;
import java.awt.*;

public class CheckFlight extends JPanel implements Page {
	public CheckFlight() {
		this.setLayout(new GridLayout(1, 1)); // 用1*1的网格布局，可以让scrollpane自动适应父元素的大小，不必使用setBounds()

		String[] columnNames = { "The flight ID", "The gate ID", "From which city", "The time of taking off", "To which city" };
		int[] idInt = DAO.SERVICE.getFlightIds();
		Object[][] obj = new Object[idInt.length][5];
		JTable table = new JTable(obj, columnNames);
		table.setEnabled(false);

		// 表头和内容的字体大小要分别设置
		table.setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));
		table.getTableHeader().setFont(new Font("", Font.ITALIC, (int) (30 * Template.getP())));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 必须禁止table自适应大小，不然table默认会适应scrollpane的宽度，就用不了滚动条了

		table.getColumnModel().getColumn(0).setPreferredWidth((int) (200 * Template.getP()));
		table.getColumnModel().getColumn(1).setPreferredWidth((int) (200 * Template.getP()));
		table.getColumnModel().getColumn(2).setPreferredWidth((int) (350 * Template.getP()));
		table.getColumnModel().getColumn(3).setPreferredWidth((int) (450 * Template.getP()));
		table.getColumnModel().getColumn(4).setPreferredWidth((int) (550 * Template.getP()));

		table.setRowHeight((int) (530 * Template.getP() / (table.getRowCount()))); // 这里指定表格的行高，600P是容器高度，用行数来平均分，+1算入了表头行

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		for (int i = 0; i < idInt.length; i++) {
			for (int j = 0; j < 5; j++) {
				switch (j) {
					case 0:
						obj[i][j] = String.valueOf(idInt[i]);
						break;
					case 1:
						obj[i][j] = String.valueOf(DAO.SERVICE.getGateId(idInt[i]));
						break;
					case 2:
						obj[i][j] = DAO.SERVICE.getFromCity(idInt[i]);
						break;
					case 3:
						obj[i][j] = DAO.SERVICE.getTime(idInt[i]);
						break;
					case 4:
						obj[i][j] = DAO.SERVICE.getToCity(idInt[i]);
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
}
