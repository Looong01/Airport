package gui.staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for staff pages
 *
 * @author Zelong Li
 * @author Ziyao Wang
 * @version 1.5
 */
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
			if (StaffGUI.getPageNum() == 1) {
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Please Login", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			} else if (JOptionPane.showConfirmDialog(StaffGUI.WINDOW, "Logout now?", "Confirmation",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				StaffGUI.setPageNum(1);
				repaintPage();
			}
		} else if (e.getSource() == Template.getBack()) {
			if (StaffGUI.getPageNum() == 1) 
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Please Login", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			else if (StaffGUI.getPageNum() == 2) { 
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Already the first page", "Prompt",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).back()) {
				StaffGUI.decreasePageNum();
				repaintPage();
			}
		} else if (e.getSource() == Template.getCont()) {
			if (StaffGUI.getPageNum() == 4) 
				JOptionPane.showMessageDialog(StaffGUI.WINDOW, "Already the last page", "Prompt",
						JOptionPane.INFORMATION_MESSAGE);
			else if (((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).cont()) {
				StaffGUI.increasePageNum();
				repaintPage();
			}
		} else
			System.err.println("Unhandled action performed");
	}

	/**
	 * repaintPage
	 */
	void repaintPage() {
		Template.getNav().setSelectedIndex(StaffGUI.getPageNum() - 1); 
		StaffGUI.WINDOW.remove(Template.getPage());

		Template.setPage(StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)); 

		StaffGUI.WINDOW.setTitle(((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).getTitle());
		Template.getInfoLabel().setText(((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).getLabel());

		Template.CONSTRAINTS.setConstraints(3, 1, 9, 6);
		Template.LAYOUT.setConstraints(Template.getPage(), Template.CONSTRAINTS);
		StaffGUI.WINDOW.add(Template.getPage());

		((Page) StaffGUI.PAGES.get(StaffGUI.getPageNum() - 1)).syncPage();

		StaffGUI.WINDOW.repaint();
		StaffGUI.WINDOW.revalidate(); // repack
	}
}
