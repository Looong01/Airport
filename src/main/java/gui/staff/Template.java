package gui.staff;

import util.gui.BufferedImageTranscoder;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Template extends JFrame implements WindowListener {
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
		// String bank = System.getProperty("user.dir") +
		// "/src/main/resources/svg/bank.svg";
		String bank = "src/main/resources/svg/bank.svg";
		BufferedImageTranscoder bit = new BufferedImageTranscoder(bank, 40 * P, 40 * P);
		JLabel iconLabel = new JLabel(new ImageIcon(bit.getImage())); // (0,0) w3h1
		infoLabel = new JLabel("template label"); // (3,0) w7h1
		logout = new JButton("LOGOUT"); // (10,0) w2h1
		nav = new JList<>(new String[] {
				"Login",
				"Check Flight",
				"Check User",
				"Check Order",
		}); // (0,1) w3h6
		nav.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// nav.setDragEnabled(false);
		// nav不可选择，不可拖拽，待实现

		// 实现

		nav.setCellRenderer(new CellRenderer());

		page = new JPanel(); // (3,1) w9h6
		back = new JButton("BACK"); // (0,7) w6h1
		cont = new JButton("CONTINUE"); // (6,7) w6h1

		// set GridBagConstraints
		CONSTRAINTS.setConstraints(0, 0, 3, 1);
		LAYOUT.setConstraints(iconLabel, CONSTRAINTS);
		CONSTRAINTS.setConstraints(3, 0, 7, 1);
		LAYOUT.setConstraints(infoLabel, CONSTRAINTS);
		CONSTRAINTS.setConstraints(10, 0, 2, 1);
		LAYOUT.setConstraints(logout, CONSTRAINTS);
		CONSTRAINTS.setConstraints(0, 1, 3, 6);
		LAYOUT.setConstraints(nav, CONSTRAINTS);
		CONSTRAINTS.setConstraints(3, 1, 9, 6);
		LAYOUT.setConstraints(page, CONSTRAINTS);
		CONSTRAINTS.setConstraints(0, 7, 6, 1);
		LAYOUT.setConstraints(back, CONSTRAINTS);
		CONSTRAINTS.setConstraints(6, 7, 6, 1);
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
		this.addWindowListener(this);

		// scaling window
		iconLabel.setPreferredSize(new Dimension((int) (300 * P), (int) (100 * P)));
		infoLabel.setPreferredSize(new Dimension((int) (700 * P), (int) (100 * P)));
		logout.setPreferredSize(new Dimension((int) (200 * P), (int) (100 * P)));
		nav.setPreferredSize(new Dimension((int) (300 * P), (int) (600 * P)));
		page.setPreferredSize(new Dimension((int) (900 * P), (int) (600 * P)));
		back.setPreferredSize(new Dimension((int) (600 * P), (int) (100 * P)));

		iconLabel.setFont(new Font("", Font.ITALIC, (int) (30 * P)));
		infoLabel.setFont(new Font("", Font.ITALIC, (int) (30 * P)));
		logout.setFont(new Font("", Font.ITALIC, (int) (30 * P)));
		nav.setFont(new Font("", Font.ITALIC, (int) (30 * P)));
		back.setFont(new Font("", Font.ITALIC, (int) (30 * P)));
		cont.setFont(new Font("", Font.ITALIC, (int) (30 * P)));

		nav.setFixedCellHeight((int) (150 * P));

		this.pack(); // pack() overrides weightx, weighty
		this.setResizable(false);

		// for scale testing
		System.out.println(LAYOUT.preferredLayoutSize(this));
		System.out.println(nav.getFont().getSize());
	}

	public static float getP() {
		return P;
	}

	public static JPanel getPage() {
		return page;
	}

	public static void setPage(JPanel page) {
		Template.page = page;
	}

	public static JLabel getInfoLabel() {
		return infoLabel;
	}

	public static JButton getLogout() {
		return logout;
	}

	public static JButton getBack() {
		return back;
	}

	public static JButton getCont() {
		return cont;
	}

	public static JList<String> getNav() {
		return nav;
	}

	@Override
	public void windowOpened(WindowEvent windowEvent) {

	}

	/**
	 * The method adds re-confirmation upon window closing
	 * 
	 * @param e the WindowEvent on window closing
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getWindow() == this) {
			if (JOptionPane.showConfirmDialog(this, "Logout and exit now?", "Confirmation",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.dispose();
				System.exit(0);
			}
		} else
			System.err.println("WindowEvent not belongs to this window");
	}

	@Override
	public void windowClosed(WindowEvent windowEvent) {

	}

	@Override
	public void windowIconified(WindowEvent windowEvent) {

	}

	@Override
	public void windowDeiconified(WindowEvent windowEvent) {

	}

	@Override
	public void windowActivated(WindowEvent windowEvent) {

	}

	@Override
	public void windowDeactivated(WindowEvent windowEvent) {

	}
}

class CellRenderer extends DefaultListCellRenderer {
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		list.setEnabled(false);
//		list.setForeground(Color.BLACK);

		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		return this;
	}
}
