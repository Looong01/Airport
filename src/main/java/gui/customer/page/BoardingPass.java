package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.BufferedImageTranscoder;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
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

	public BoardingPass() {
		GridBagLayoutConstraints constraints = new GridBagLayoutConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		JPanel mainPanel = new JPanel(new GridLayout(6,1));
		JPanel sidePanel = new JPanel(new GridLayout(6,1));

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
		BufferedImageTranscoder iconTranscoder = new BufferedImageTranscoder("src/main/resources/svg/apple.svg",60 * Template.getP(),60 * Template.getP());
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
		boardingTitlePanel.add(new JLabel("Gate"));
		boardingTitlePanel.add(new JLabel("Boarding Time"));
		boardingTitlePanel.add(new JLabel("Seat No."));

		// boardingPanel
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

		// TO DO JLabelel.CENTER全局化，可以@Override JLabelel类

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

		Display.setPageFont(this);
	}

	@Override
	public void syncPage() {
		/*DAO.setCustomer(SERVICE.LoginByCardId("140109200010204817"));
		DAO.setOrder(SERVICE.getOrder(1000111));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));*/ // TODO delete it
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
	public String getCont() {
		return "EXIT";
	}

	@Override
	public boolean back() {
		return true;
	}

	@Override
	public boolean cont() {
		return true;
	}
}
