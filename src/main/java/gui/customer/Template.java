package gui.customer;

import util.gui.BufferedImageTranscoder;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Customer page template
 *
 * @author Ziyao Wang
 * @author Zelong Li
 * @version 1.5
 */
public class Template extends JFrame {
	// GridBagLayout
	static final GridBagLayout LAYOUT = new GridBagLayout();
	static final GridBagLayoutConstraints CONSTRAINTS = new GridBagLayoutConstraints();
	private static final float P = Display.getProp();
	private static JPanel page;
	private static JLabel infoLabel;
	private static JButton logout, back, cont;
	private static JList<String> nav;

	/**
	 * Constructor for Template
	 */
	public Template() {
		// set frame
		this.setTitle("template title");
		this.setLayout(LAYOUT); // 12 * 8
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // confirmation needed
		// instantiate components
		String bank = "src/main/resources/svg/bank.svg";
		BufferedImageTranscoder bit = new BufferedImageTranscoder(bank,80 * P,80 * P);
		JLabel iconLabel = new JLabel(new ImageIcon(bit.getImage())); // (0,0) w3h1
		infoLabel = new JLabel("template label"); // (3,0) w7h1
		logout = new JButton("LOGOUT"); // (10,0) w2h1
		nav = new JList<>(new String[]{
				"Login",
				"Review Order",
				"Choose Seat",
				"Choose Food",
				"Payment",
				"Boarding Pass"
		}); // (0,1) w3h6
		nav.setCellRenderer(new DefaultListCellRenderer() { // navigation not clickable
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				list.setEnabled(false);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				list.setDragEnabled(false);
				return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			}
		});
		page = new JPanel(); // (3,1) w9h6
		back = new JButton("BACK"); // (0,7) w6h1
		cont = new JButton("CONTINUE"); // (6,7) w6h1
		// set GridBagConstraints
		CONSTRAINTS.setConstraints(0,0,3,1);
		LAYOUT.setConstraints(iconLabel, CONSTRAINTS);
		CONSTRAINTS.setConstraints(3,0,7,1);
		LAYOUT.setConstraints(infoLabel, CONSTRAINTS);
		CONSTRAINTS.setConstraints(10,0,2,1);
		LAYOUT.setConstraints(logout, CONSTRAINTS);
		CONSTRAINTS.setConstraints(0,1,3,6);
		LAYOUT.setConstraints(nav, CONSTRAINTS);
		CONSTRAINTS.setConstraints(3,1,9,6);
		LAYOUT.setConstraints(page, CONSTRAINTS);
		CONSTRAINTS.setConstraints(0,7,6,1);
		LAYOUT.setConstraints(back, CONSTRAINTS);
		CONSTRAINTS.setConstraints(6,7,6,1);
		LAYOUT.setConstraints(cont, CONSTRAINTS);
		// add components
		this.add(iconLabel);
		this.add(infoLabel);
		this.add(logout);
		this.add(nav);
		this.add(page);
		this.add(back);
		this.add(cont);
		// add listeners
		this.addWindowListener(new WindowAdapter() {
			/**
			 * The method adds re-confirmation upon window closing
			 * @param e window closing event
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				if (e.getWindow() == Template.this) {
					if (JOptionPane.showConfirmDialog(Template.this, "Logout and exit now?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Template.this.dispose();
						System.exit(0);
					}
				} else
					System.err.println("WindowEvent not belongs to this window");
			}
		});
		// scaling font
		infoLabel.setFont(new Font(Font.SERIF, Font.ITALIC, (int) (40 * P)));
		logout.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (35 * P)));
		nav.setFont(new Font(Font.SERIF, Font.ITALIC, (int) (40 * P)));
		back.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (25 * P)));
		cont.setFont(new Font(Font.MONOSPACED, Font.ITALIC, (int) (25 * P)));
		// scaling window
		iconLabel.setPreferredSize(new Dimension((int) (300 * P), (int) (100 * P)));
		infoLabel.setPreferredSize(new Dimension((int) (700 * P), (int) (100 * P)));
		logout.setPreferredSize(new Dimension((int) (200 * P), (int) (100 * P)));
		nav.setPreferredSize(new Dimension((int) (300 * P), (int) (600 * P)));
		page.setPreferredSize(new Dimension((int) (900 * P), (int) (600 * P)));
		back.setPreferredSize(new Dimension((int) (600 * P), (int) (100 * P)));
		nav.setFixedCellHeight((int) (100 * P)); // 600 / 6 = 100
		this.pack(); // pack() overrides weightx, weighty
		this.setResizable(false);
	}

	/**
	 * get prop
	 * @return float
	 */
	public static float getP() {
		return P;
	}

	/**
	 * get page
	 * @return JPanel
	 */
	public static JPanel getPage() {
		return page;
	}

	/**
	 * set page
	 * @param page JPanel
	 */
	public static void setPage(JPanel page) {
		Template.page = page;
	}

	/**
	 * get information label
	 * @return JLabel
	 */
	public static JLabel getInfoLabel() {
		return infoLabel;
	}

	/**
	 * get logout button
	 * @return JButton
	 */
	public static JButton getLogout() {
		return logout;
	}

	/**
	 * get back button
	 * @return JButton
	 */
	public static JButton getBack() {
		return back;
	}

	/**
	 * get continue button
	 * @return JButton
	 */
	public static JButton getCont() {
		return cont;
	}

	/**
	 * get navigation
	 * @return JList
	 */
	public static JList<String> getNav() {
		return nav;
	}
}