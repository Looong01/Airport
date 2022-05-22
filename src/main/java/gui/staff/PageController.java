package gui.staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.staff.page.*;
import gui.staff.dao.*;

public class PageController implements ActionListener {
	private Login loginPage;

	/**
	 * Constructor for PageController listening to logout, back, and continue
	 * buttons
	 */
	public PageController() {
		Template.getLogout().addActionListener(this);
		Template.getBack().addActionListener(this);
		Template.getCont().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Template.getLogout()) {
			if (StaffGUI.getPageNum() == 1) {
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Please Login", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			} else if (JOptionPane.showConfirmDialog(StaffGUI.WINDOW, "Logout and exit now?", "Confirmation",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				StaffGUI.setPageNum(1);
				repaintPage();
			}
		} else if (e.getSource() == Template.getBack()) {
			if (StaffGUI.getPageNum() == 1) // login page
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Please Login", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			else if (StaffGUI.getPageNum() == 2) { // the first page
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Already the first page", "Prompt",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				StaffGUI.decreasePageNum();
				repaintPage();
			}
		} else if (e.getSource() == Template.getCont()) {
			if (StaffGUI.getPageNum() == 1) {// the last page
				String cardId = loginPage.textField.getText();
				String password = new String(loginPage.passwordField.getPassword());
				boolean TorF = DAO.SERVICE.loginByPasswd(cardId, password);
				if (TorF) {
					JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Login successfully", "Prompt",
							JOptionPane.INFORMATION_MESSAGE);
					StaffGUI.increasePageNum();
					repaintPage();
				} else
					JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Login failed", "Prompt",
							JOptionPane.INFORMATION_MESSAGE);
			} else if (StaffGUI.getPageNum() == 4) // the last page 之后去掉button
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Already the last page", "Prompt",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				StaffGUI.increasePageNum();
				repaintPage();
			}
		} else
			System.err.println("Unhandled action performed");
	}

	void repaintPage() {
		Template.getNav().setSelectedIndex(StaffGUI.getPageNum() - 1); // set navigation
		StaffGUI.WINDOW.remove(Template.getPage());

		Template.setPage(StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)); // 数组从0开始

		StaffGUI.WINDOW.setTitle(((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).getTitle());
		Template.getInfoLabel().setText(((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).getLabel());

		Template.CONSTRAINTS.setConstraints(3, 1, 9, 6);
		Template.LAYOUT.setConstraints(Template.getPage(), Template.CONSTRAINTS);
		StaffGUI.WINDOW.add(Template.getPage());

		StaffGUI.WINDOW.repaint();
		StaffGUI.WINDOW.revalidate(); // repack
	}

	public void setLoginPage(Login loginpage) {
		this.loginPage = loginpage;
	}

}
