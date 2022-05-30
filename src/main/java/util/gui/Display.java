package util.gui;

import gui.customer.Template;

import javax.swing.*;
import java.awt.*;

/**
 * The class achieves proper display of customer GUI
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class Display {
	/**
	 * The method
	 * @return Proportion for scaling GUI
	 */
	public static float getProp() {
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets((new JFrame()).getGraphicsConfiguration()); // screen border information
		int screenHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - screenInsets.top - screenInsets.bottom); // available screen height without borders
		return (float) (Math.floor(screenHeight / 800. * 2) / 2.);
	}

	/**
	 * The method sets fonts for JPanel
	 * @param page one of six customer pages
	 * @param size size of font with proportion 1
	 */
	public static void setPanelFont(JPanel page, int size) {
		setFont(page.getComponents(), size);
	}

	/**
	 * The method sets fonts for JPanel with default size = 30
	 * @param page one of six customer pages
	 */
	public static void setPanelFont(JPanel page) {
		setFont(page.getComponents(), 30);
	}

	/**
	 * The method sets fonts for JFrame with default size = 30
	 * @param page JFrame object
	 */
	public static void setFrameFont(JFrame page) {
		setFont(page.getContentPane().getComponents(), 30);
	}

	/**
	 * basic set font method called by other methods
	 * @param components Component[]
	 * @param size int
	 */
	private static void setFont(Component[] components, int size) {
		for (Component component : components) {
			if (component instanceof JPanel) {
				Component[] comps = ((JPanel) component).getComponents();
				for (Component comp : comps) {
					if (comp instanceof JPanel) {
						Component[] cs = ((JPanel) comp).getComponents();
						for (Component c : cs)
							c.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (size * Template.getP())));
					} else comp.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (size * Template.getP())));
				}
			} else component.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (size * Template.getP())));
		}
	}
}