package gui.staff;

import gui.staff.page.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The class holds staff pages and controller
 *
 * @author Zelong Li
 * @author Ziyao Wang
 * @version 1.5
 */
public class StaffGUI {
	static final ArrayList<JPanel> PAGES = new ArrayList<>();
	static final Template WINDOW = new Template();
	private static int pageNum = 1;
	private static final PageController CONTROLLER = new PageController();

	static {
		// localize the JVM process
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(WINDOW);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				 | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		PAGES.add(new Login()); // P1
		PAGES.add(new CheckFlight()); // P2
		PAGES.add(new CheckUser()); // P3
		PAGES.add(new CheckOrder()); // P4

		// login page
		CONTROLLER.repaintPage();

		// centered display
		WINDOW.setLocationRelativeTo(null);
	}

	/**
	 * get page number
	 * @return int page number
	 */
	public static int getPageNum() {
		return pageNum;
	}

	/**
	 * set page number
	 * @param pageNum int
	 */
	public static void setPageNum(int pageNum) {
		StaffGUI.pageNum = pageNum;
	}

	/**
	 * pageNum++
	 */
	public static void increasePageNum() {
		++pageNum;
	}

	/**
	 * pageNum--
	 */
	public static void decreasePageNum() {
		--pageNum;
	}

	/**
	 * get window
	 * @return Template window
	 */
	public static Template getWindow() {
		return WINDOW;
	}
}
