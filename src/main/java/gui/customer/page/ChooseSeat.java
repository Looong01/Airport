package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.BufferedImageTranscoder;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Choose seat page
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class ChooseSeat extends JPanel implements Page {
	private final String seatSVG = "src/main/resources/svg/seat"; // cannot use absolute path for BufferedImageTranscoder
	private final BufferedImageTranscoder seatTranscoder = new BufferedImageTranscoder(seatSVG + ".svg",60 * Template.getP(),60 * Template.getP());
	private final BufferedImageTranscoder oSeatTranscoder = new BufferedImageTranscoder(seatSVG + "-occupied.svg",60 * Template.getP(),60 * Template.getP());
	private final BufferedImageTranscoder rSeatTranscoder = new BufferedImageTranscoder(seatSVG + "-rollover.svg",60 * Template.getP(),60 * Template.getP());
	private final BufferedImageTranscoder cSeatTranscoder = new BufferedImageTranscoder(seatSVG + "-chosen.svg",60 * Template.getP(),60 * Template.getP());
	private final ButtonGroup group = new ButtonGroup();

	/**
	 * constructor for choose seat
	 */
	public ChooseSeat() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		JList<String> seatClass = new JList<>(new String[]{
				"First Class +$200",
				"Economy Class +$0",
				"Extra Legroom +$50"
		});
		CardLayout cardLayout = new CardLayout();
		JPanel panel = new JPanel(cardLayout);

		GridBagLayoutConstraints constraints = new GridBagLayoutConstraints();
		constraints.setConstraints(0,0,3,6);
		layout.setConstraints(seatClass, constraints);
		constraints.setConstraints(3,0,6,6);
		layout.setConstraints(panel, constraints);

		seatClass.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		seatClass.setDragEnabled(false);
		seatClass.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting())
				cardLayout.show(panel, (String) ((JList<?>) e.getSource()).getSelectedValue());
		});

		// 50 seats
		JSeat seat1 = new JSeat(1);
		JSeat seat2 = new JSeat(2);
		JSeat seat3 = new JSeat(3);
		JSeat seat4 = new JSeat(4);
		JSeat seat5 = new JSeat(5);
		JSeat seat6 = new JSeat(6);
		JSeat seat7 = new JSeat(7);
		JSeat seat8 = new JSeat(8);
		JSeat seat9 = new JSeat(9);
		JSeat seat10 = new JSeat(10);
		JSeat seat11 = new JSeat(11);
		JSeat seat12 = new JSeat(12);
		JSeat seat13 = new JSeat(13);
		JSeat seat14 = new JSeat(14);
		JSeat seat15 = new JSeat(15);
		JSeat seat16 = new JSeat(16);
		JSeat seat17 = new JSeat(17);
		JSeat seat18 = new JSeat(18);
		JSeat seat19 = new JSeat(19);
		JSeat seat20 = new JSeat(20);
		JSeat seat21 = new JSeat(21);
		JSeat seat22 = new JSeat(22);
		JSeat seat23 = new JSeat(23);
		JSeat seat24 = new JSeat(24);
		JSeat seat25 = new JSeat(25);
		JSeat seat26 = new JSeat(26);
		JSeat seat27 = new JSeat(27);
		JSeat seat28 = new JSeat(28);
		JSeat seat29 = new JSeat(29);
		JSeat seat30 = new JSeat(30);
		JSeat seat31 = new JSeat(31);
		JSeat seat32 = new JSeat(32);
		JSeat seat33 = new JSeat(33);
		JSeat seat34 = new JSeat(34);
		JSeat seat35 = new JSeat(35);
		JSeat seat36 = new JSeat(36);
		JSeat seat37 = new JSeat(37);
		JSeat seat38 = new JSeat(38);
		JSeat seat39 = new JSeat(39);
		JSeat seat40 = new JSeat(40);
		JSeat seat41 = new JSeat(41);
		JSeat seat42 = new JSeat(42);
		JSeat seat43 = new JSeat(43);
		JSeat seat44 = new JSeat(44);
		JSeat seat45 = new JSeat(45);
		JSeat seat46 = new JSeat(46);
		JSeat seat47 = new JSeat(47);
		JSeat seat48 = new JSeat(48);
		JSeat seat49 = new JSeat(49);
		JSeat seat50 = new JSeat(50);

		// button group
		group.add(seat1);
		group.add(seat2);
		group.add(seat3);
		group.add(seat4);
		group.add(seat5);
		group.add(seat6);
		group.add(seat7);
		group.add(seat8);
		group.add(seat9);
		group.add(seat10);
		group.add(seat11);
		group.add(seat12);
		group.add(seat13);
		group.add(seat14);
		group.add(seat15);
		group.add(seat16);
		group.add(seat17);
		group.add(seat18);
		group.add(seat19);
		group.add(seat20);
		group.add(seat21);
		group.add(seat22);
		group.add(seat23);
		group.add(seat24);
		group.add(seat25);
		group.add(seat26);
		group.add(seat27);
		group.add(seat28);
		group.add(seat29);
		group.add(seat30);
		group.add(seat31);
		group.add(seat32);
		group.add(seat33);
		group.add(seat34);
		group.add(seat35);
		group.add(seat36);
		group.add(seat37);
		group.add(seat38);
		group.add(seat39);
		group.add(seat40);
		group.add(seat41);
		group.add(seat42);
		group.add(seat43);
		group.add(seat44);
		group.add(seat45);
		group.add(seat46);
		group.add(seat47);
		group.add(seat48);
		group.add(seat49);
		group.add(seat50);

		// first class
		JPanel panel1 = new JPanel(new GridLayout(2, 5));
		panel1.add(seat1);
		panel1.add(seat2);
		panel1.add(new JLabel());
		panel1.add(seat3);
		panel1.add(seat4);
		panel1.add(seat5);
		panel1.add(seat6);
		panel1.add(new JLabel());
		panel1.add(seat7);
		panel1.add(seat8);

		// economy class
		JPanel panel2 = new JPanel(new GridLayout(6, 7));
		panel2.add(seat15);
		panel2.add(seat16);
		panel2.add(seat17);
		panel2.add(new JLabel());
		panel2.add(seat18);
		panel2.add(seat19);
		panel2.add(seat20);

		panel2.add(seat21);
		panel2.add(seat22);
		panel2.add(seat23);
		panel2.add(new JLabel());
		panel2.add(seat24);
		panel2.add(seat25);
		panel2.add(seat26);

		panel2.add(seat27);
		panel2.add(seat28);
		panel2.add(seat29);
		panel2.add(new JLabel());
		panel2.add(seat30);
		panel2.add(seat31);
		panel2.add(seat32);

		panel2.add(seat33);
		panel2.add(seat34);
		panel2.add(seat35);
		panel2.add(new JLabel());
		panel2.add(seat36);
		panel2.add(seat37);
		panel2.add(seat38);

		panel2.add(seat39);
		panel2.add(seat40);
		panel2.add(seat41);
		panel2.add(new JLabel());
		panel2.add(seat42);
		panel2.add(seat43);
		panel2.add(seat44);

		panel2.add(seat45);
		panel2.add(seat46);
		panel2.add(seat47);
		panel2.add(new JLabel());
		panel2.add(seat48);
		panel2.add(seat49);
		panel2.add(seat50);

		// extra legroom
		JPanel panel3 = new JPanel(new GridLayout(1, 7));
		panel3.add(seat9);
		panel3.add(seat10);
		panel3.add(seat11);
		panel3.add(new JLabel());
		panel3.add(seat12);
		panel3.add(seat13);
		panel3.add(seat14);

		// cardLayout
		panel.add("First Class +$200", panel1);
		panel.add("Economy Class +$0", panel2);
		panel.add("Extra Legroom +$50", panel3);

		this.add(seatClass);
		this.add(panel);

		seatClass.setPreferredSize(new Dimension((int) (300 * Template.getP()), (int) (600 * Template.getP())));
		panel.setPreferredSize(new Dimension((int) (600 * Template.getP()), (int) (600 * Template.getP())));

		seatClass.setFixedCellHeight((int) (200 * Template.getP())); // 600 / 3 = 200
		seatClass.setSelectedIndex(0);
		seatClass.setFont(new Font(Font.SERIF, Font.ITALIC, (int) (30 * Template.getP())));
	}

	/**
	 * JSeat extends JRadioButton
	 */
	private class JSeat extends JRadioButton {
		private final int seatId;

		/**
		 * constructor for JSeat
		 * @param seatId seat ID
		 */
		public JSeat(int seatId) {
			super();
			this.seatId = seatId;
			this.setIcon(new ImageIcon(seatTranscoder.getImage()));
			this.setDisabledIcon(new ImageIcon(oSeatTranscoder.getImage()));
			this.setRolloverIcon(new ImageIcon(rSeatTranscoder.getImage()));
			this.setSelectedIcon(new ImageIcon(cSeatTranscoder.getImage()));
			this.addActionListener(e -> { // actionListener cannot capture deselection from buttongroup
				if (seatId <= 8) // first class
					DAO.setSeatDue(200);
				else if (seatId <= 14) // extra legroom
					DAO.setSeatDue(50);
				else // economy class
					DAO.setSeatDue(0);
				Template.getCont().setText("DUE $" + DAO.getSeatDue());
			});
		}
	}

	@Override
	public void syncPage() {
		if (!DAO.isSeatSelected()) { // initialization
			ArrayList<Integer> occupiedSeats = DAO.getFlight().getOccupiedSeats();
			group.clearSelection();
			Enumeration<AbstractButton> seats = group.getElements();

			for (int i = 1; i <= 50 && seats.hasMoreElements(); ++i)
				seats.nextElement().setEnabled(!occupiedSeats.contains(i));
		}
		Template.getCont().setText("DUE $" + DAO.getSeatDue());
	}

	@Override
	public String getTitle() {
		return "Choose Seat";
	}

	@Override
	public String getLabel() {
		return "Please choose your seat";
	}

	@Override
	public boolean back() {
		return true;
	}

	@Override
	public boolean cont() {
		Enumeration<AbstractButton> seats = group.getElements();
		AbstractButton abstractButton;
		while (seats.hasMoreElements()) {
			abstractButton = seats.nextElement();
			if (abstractButton.isSelected()) {
				DAO.getOrder().setSeatId(((JSeat) abstractButton).seatId);
				DAO.setSeatSelected(true);
				return true;
			}
		}

		JOptionPane.showMessageDialog(this, "Please choose your seat", "Prompt", JOptionPane.ERROR_MESSAGE);
		return false;
	}
}
