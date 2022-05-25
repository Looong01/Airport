package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.BufferedImageTranscoder;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;
import util.string.MessageSHA256;
import util.scan.QRCodeUtil;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class BoardingPass extends JPanel implements Page {
	private final JLabel infoLabel = new JLabel();
	private final JLabel cityLabel = new JLabel();
	private final JLabel flight = new JLabel();
	private final JLabel name = new JLabel();
	private final JLabel gate = new JLabel();
	private final JLabel boardingTime = new JLabel();
	private final JLabel seatNo = new JLabel();
	private final JLabel sideFlight = new JLabel();
	private final JLabel sideName = new JLabel();
	private final JLabel sideTo = new JLabel();
	private final JLabel sideDate = new JLabel();
	private final JLabel sideSeatNo = new JLabel();
	private JFrame tagFrame;
	private JFrame ticketFrame;

	public BoardingPass() {
		GridBagLayoutConstraints constraints = new GridBagLayoutConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		JPanel mainPanel = new JPanel(new GridLayout(6,1));
		JPanel sidePanel = new JPanel(new GridLayout(6,1));
		sidePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		constraints.setConstraints(0,0,5,4);
		layout.setConstraints(mainPanel, constraints);
		constraints.setConstraints(5,0,1,4);
		layout.setConstraints(sidePanel, constraints);

		// main panel
		GridBagLayout titleLayout = new GridBagLayout();
		GridBagLayout flightLayout = new GridBagLayout();
		JPanel titlePanel = new JPanel(titleLayout);
		JPanel flightTitlePanel = new JPanel(flightLayout);
		JPanel flightPanel = new JPanel(flightLayout);
		JPanel boardingTitlePanel = new JPanel(new GridLayout(1,3));
		JPanel boardingPanel = new JPanel(new GridLayout(1,3));

		// titlePanel
		BufferedImageTranscoder iconTranscoder = new BufferedImageTranscoder("src/main/resources/svg/apple.svg",80 * Template.getP(),80 * Template.getP());
		JLabel iconLabel = new JLabel(new ImageIcon(iconTranscoder.getImage()));

		constraints.setConstraints(0,0,3,2);
		titleLayout.setConstraints(iconLabel, constraints);
		constraints.setConstraints(3,0,12,2);
		titleLayout.setConstraints(infoLabel, constraints);

		titlePanel.add(iconLabel);
		titlePanel.add(infoLabel);

		// flightTitlePanel
		JLabel flightTitle = new JLabel("Flight / Date / Class");
		JLabel nameTitle = new JLabel("Name");

		constraints.setConstraints(0,0,10,2);
		flightLayout.setConstraints(flightTitle, constraints);
		constraints.setConstraints(10,0,5,2);
		flightLayout.setConstraints(nameTitle, constraints);

		flightTitlePanel.add(flightTitle);
		flightTitlePanel.add(nameTitle);

		// flightPanel
		constraints.setConstraints(0,0,10,2);
		flightLayout.setConstraints(flight, constraints);
		constraints.setConstraints(10,0,5,2);
		flightLayout.setConstraints(name, constraints);

		flightPanel.add(flight);
		flightPanel.add(name);

		// boardingTitlePanel
		boardingTitlePanel.add(new JLabel("Gate", JLabel.CENTER));
		boardingTitlePanel.add(new JLabel("Boarding Time", JLabel.CENTER));
		boardingTitlePanel.add(new JLabel("Seat No.", JLabel.CENTER));

		// boardingPanel
		gate.setHorizontalAlignment(JLabel.CENTER);
		boardingTime.setHorizontalAlignment(JLabel.CENTER);
		seatNo.setHorizontalAlignment(JLabel.CENTER);
		boardingPanel.add(gate);
		boardingPanel.add(boardingTime);
		boardingPanel.add(seatNo);

		mainPanel.add(titlePanel);
		mainPanel.add(flightTitlePanel);
		mainPanel.add(flightPanel);
		mainPanel.add(cityLabel);
		mainPanel.add(boardingTitlePanel);
		mainPanel.add(boardingPanel);

		// side panel
		sidePanel.add(new JLabel(new ImageIcon(iconTranscoder.getImage())));
		sidePanel.add(sideFlight);
		sidePanel.add(sideName);
		sidePanel.add(sideTo);
		sidePanel.add(sideDate);
		sidePanel.add(sideSeatNo);

		this.add(mainPanel);
		this.add(sidePanel);

		mainPanel.setPreferredSize(new Dimension((int) (750 * Template.getP()), (int) (600 * Template.getP())));
		iconLabel.setPreferredSize(new Dimension((int) (150 * Template.getP()), (int) (100 * Template.getP())));
		infoLabel.setPreferredSize(new Dimension((int) (600 * Template.getP()), (int) (100 * Template.getP())));
		flightTitle.setPreferredSize(new Dimension((int) (500 * Template.getP()), (int) (100 * Template.getP())));
		nameTitle.setPreferredSize(new Dimension((int) (250 * Template.getP()), (int) (100 * Template.getP())));
		flight.setPreferredSize(new Dimension((int) (500 * Template.getP()), (int) (100 * Template.getP())));
		name.setPreferredSize(new Dimension((int) (250 * Template.getP()), (int) (100 * Template.getP())));
		sidePanel.setPreferredSize(new Dimension((int) (150 * Template.getP()), (int) (600 * Template.getP())));

		Display.setPanelFont(this);
	}

	@Override
	public void syncPage() {
		/*DAO.setCustomer(SERVICE.loginByCardId("140109200010204817"));
		DAO.setOrder(SERVICE.getOrder("gCBlsM+AYu"));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));*/

		String[] dates = DAO.getFlight().getTime().split(" ");
		String[] times = dates[3].split(":");
		String[] names = DAO.getCustomer().getName().split(" ");

		infoLabel.setText(DAO.getFlight().getFromCity() + " Airport");

		if (DAO.getOrder().getSeatId() <= 8) // first class
			flight.setText(DAO.getFlight().getFlightId() + " / " + dates[2] + dates[1] + " / First");
		else if (DAO.getOrder().getSeatId() <= 14) // extra legroom
			flight.setText(DAO.getFlight().getFlightId() + " / " + dates[2] + dates[1] + " / Legroom");
		else // economy class
			flight.setText(DAO.getFlight().getFlightId() + " / " + dates[2] + dates[1] + " / Economy");

		name.setText(DAO.getCustomer().getName());
		cityLabel.setText("From " + DAO.getFlight().getFromCity() + " To " + DAO.getFlight().getToCity());
		gate.setText(DAO.getFlight().getGateId() + "");
		boardingTime.setText(times[0] + times[1]); // TODO 向前提前30分钟
		seatNo.setText(DAO.getOrder().getSeatId() + "");

		sideFlight.setText("" + DAO.getFlight().getFlightId());
		sideName.setText(names[0].charAt(0) + " " + names[1]);
		sideTo.setText(DAO.getFlight().getToCity().split(" ")[0]);
		sideDate.setText(dates[2] + dates[1]);
		sideSeatNo.setText("" + DAO.getOrder().getSeatId());
	}

	@Override
	public String getTitle() {
		return "Boarding Pass";
	}

	@Override
	public String getLabel() {
		return "Here is your printed boarding pass";
	}

	@Override
	public String getBack() {
		return "TAG";
	}

	@Override
	public String getCont() {
		return "TICKET";
	}

	@Override
	public boolean back() {
		if (DAO.getOrder().getCarryOn() == 0) {
			JOptionPane.showMessageDialog(this, "No carry-on baggage", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (tagFrame != null)
			tagFrame.dispose();
		tagFrame = generateFrame("Carry-on Baggage Tag");
		tagFrame.setVisible(true);
		return false;
	}

	@Override
	public boolean cont() {
		if (DAO.getOrder().getCheckIn() == 0) {
			JOptionPane.showMessageDialog(this, "No check-in baggage", "Prompt", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (ticketFrame != null)
			ticketFrame.dispose();
		ticketFrame = generateFrame("Check-in Bag Drop Ticket");
		ticketFrame.setVisible(true);
		return false;
	}

	private JFrame generateFrame(String title) {
		JFrame frame = new JFrame(title);
		JPanel south = new JPanel(new BorderLayout());
		JLabel label = new JLabel(DAO.getFlight().getFromCity() + " Airport", JLabel.CENTER);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);

		String[] dates = DAO.getFlight().getTime().split(" ");
		if (title.contains("Tag")) { // carry-on
			textArea.append("CARRY-ON_BAG " + DAO.getOrder().getCarryOn() + "\t" + DAO.getFlight().getFlightId() + "\n");
			textArea.append("SEAT " + DAO.getOrder().getSeatId() + "\t");
		} else { // check-in
			textArea.append("CHECK-IN_BAG " + DAO.getOrder().getCheckIn() + "\t" + DAO.getFlight().getFlightId() + "\n");
			textArea.append("COUNTER " + DAO.getOrder().getPackageGate());
		}
		textArea.append("\t" + dates[2] + dates[1] + "\nTO " + DAO.getFlight().getToCity());

		MessageSHA256 sha256 = new MessageSHA256();
		String code = sha256.encode(DAO.getOrder().getOrderId());
		JLabel label1 = new JLabel(sha256.encode(textArea.getText()), JLabel.CENTER);
		JLabel label2 = new JLabel(code, JLabel.CENTER);
		south.add(label1, BorderLayout.NORTH);
		south.add(new JLabel(new ImageIcon(QRCodeUtil.createImage(code, (int) (575 * Template.getP())))), BorderLayout.CENTER);
		south.add(label2, BorderLayout.SOUTH);

		frame.add(label, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);

		Display.setFrameFont(frame);
		label.setFont(new Font(Font.SERIF, Font.ITALIC, (int) (60 * Template.getP())));
		label1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, (int) (15 * Template.getP())));
		label2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, (int) (15 * Template.getP())));

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		return frame;
	}
}
