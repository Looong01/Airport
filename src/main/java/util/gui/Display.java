package util.gui;

import gui.customer.Template;

import javax.swing.*;
import java.awt.*;

/*// scaling JCheckBox icon
if (comp instanceof JCheckBox) {
	String square = System.getProperty("user.dir") + "/src/main/resources/square.svg";
	String checkedSquare = System.getProperty("user.dir") + "/src/main/resources/check-square-fill.svg";
	BufferedImageTranscoder bit0 = new BufferedImageTranscoder(square, fontSize * propX, fontSize * propY);
	BufferedImageTranscoder bit1 = new BufferedImageTranscoder(checkedSquare, fontSize * propX, fontSize * propY);

	((JCheckBox) comp).setIcon(new ImageIcon(bit0.getImage()));
	((JCheckBox) comp).setSelectedIcon(new ImageIcon(bit1.getImage()));
}*/

/**
 * The class achieves proper display of customer GUI
 * @author wzy
 * @version 2.0
 */
public class Display {
	/**
	 * The method
	 * @return Proportion for scaling GUI
	 */
	public static float getProp() {
		// GraphicDevice获取物理分辨率而非系统分辨率，在Mac OS X上例外

		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets((new JFrame()).getGraphicsConfiguration()); // screen border information
		int screenHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - screenInsets.top - screenInsets.bottom); // available screen height without borders

		/*System.out.println("OS: " + System.getProperty("os.name"));
		System.out.println("LogicalScreenSize (Toolkit) = " + (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() + " * " + (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		System.out.println("availableHeight = " + screenHeight);*/

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
