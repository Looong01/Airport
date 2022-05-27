package gui.customer;

import gui.customer.page.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The class holds customer pages and controller
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class CustomerGUI {
	static final ArrayList<JPanel> PAGES = new ArrayList<>();
	static final Template WINDOW = new Template();
	private static int pageNum = 1;
	private static final PageController CONTROLLER = new PageController();

	static {
		// localize the JVM process
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(WINDOW);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		PAGES.add(new Login()); // P1
		PAGES.add(new ReviewOrder()); // P2
		PAGES.add(new ChooseSeat()); // P3
		PAGES.add(new ChooseFood()); // P4
		PAGES.add(new Payment()); // P5
		PAGES.add(new BoardingPass()); // P6

		// login page
		CONTROLLER.repaintPage();

		// centered display
		WINDOW.setLocationRelativeTo(null);
//		WINDOW.setVisible(true);
	}

	public static int getPageNum() {
		return pageNum;
	}

	public static void setPageNum(int pageNum) {
		CustomerGUI.pageNum = pageNum;
	}

	public static void increasePageNum() {
		++pageNum;
	}

	public static void decreasePageNum() {
		--pageNum;
	}

	public static Template getWindow() {
		return WINDOW;
	}
}
