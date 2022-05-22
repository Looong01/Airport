package gui.customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageController implements ActionListener {
	/**
	 * Constructor for PageController listening to logout, back, and continue buttons
	 */
	public PageController() {
		Template.getLogout().addActionListener(this);
		Template.getBack().addActionListener(this);
		Template.getCont().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Template.getLogout()) {
			if (CustomerGUI.getPageNum() == 1) // the first page
				JOptionPane.showMessageDialog(CustomerGUI.WINDOW, "Please Login", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			else if (JOptionPane.showConfirmDialog(CustomerGUI.WINDOW, "Logout now?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				CustomerGUI.setPageNum(1);
				repaintPage();
			}
		} else if (e.getSource() == Template.getBack()) {
			if (CustomerGUI.getPageNum() == 1) // the first page
				JOptionPane.showMessageDialog(CustomerGUI.WINDOW, "Already the first page", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			else {
				if (((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).back()) {
					CustomerGUI.decreasePageNum();
					repaintPage();
				}
			}
		} else if (e.getSource() == Template.getCont()) {
			if (CustomerGUI.getPageNum() == 6) {
				if (JOptionPane.showConfirmDialog(CustomerGUI.WINDOW, "Exit now?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			else {
				if (((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).cont()) {
					CustomerGUI.increasePageNum();
					repaintPage();
				}
			}
		} else
			System.err.println("Unhandled action performed");
	}

	void repaintPage() {
		Template.getNav().setSelectedIndex(CustomerGUI.getPageNum() - 1); // set navigation
		CustomerGUI.WINDOW.remove(Template.getPage());

		Template.setPage(CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)); // 数组从0开始

		CustomerGUI.WINDOW.setTitle(((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).getTitle());
		Template.getInfoLabel().setText(((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).getLabel());
		Template.getBack().setText(((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).getBack());
		Template.getCont().setText(((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).getCont());

		Template.CONSTRAINTS.setConstraints(3,1,9,6);
		Template.LAYOUT.setConstraints(Template.getPage(), Template.CONSTRAINTS);
		CustomerGUI.WINDOW.add(Template.getPage());

		((Page) CustomerGUI.PAGES.get(CustomerGUI.getPageNum() - 1)).syncPage(); // 从CustomerDAO更新page的内容

		CustomerGUI.WINDOW.repaint();
		CustomerGUI.WINDOW.revalidate(); // repack
	}
}