package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.BufferedImageTranscoder;
import util.gui.Display;
import util.gui.GridBagLayoutConstraints;

import javax.swing.*;
import java.awt.*;

public class BoardingPass extends JPanel implements Page {
	private final JLab infoLabel = new JLab();
	private final JLab cityLabel = new JLab();
	private final JLab flight = new JLab();
	private final JLab name = new JLab();
	private final JLab gate = new JLab();
	private final JLab boardingTime = new JLab();
	private final JLab seatNo = new JLab();
	private final JLab sideFlight = new JLab();
	private final JLab sideName = new JLab();
	private final JLab sideTo = new JLab();
	private final JLab sideDate = new JLab();
	private final JLab sideSeatNo = new JLab();

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
		JLab iconLabel = new JLab(new ImageIcon(iconTranscoder.getImage()));

		constraints.setConstraints(0,0,3,2);
		titleLayout.setConstraints(iconLabel, constraints);
		constraints.setConstraints(3,0,12,2);
		titleLayout.setConstraints(infoLabel, constraints);

		titlePanel.add(iconLabel);
		titlePanel.add(infoLabel);

		// flightTitlePanel
		JLab flightTitle = new JLab("Flight / Date / Class");
		JLab nameTitle = new JLab("Name");

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
		boardingTitlePanel.add(new JLab("Gate"));
		boardingTitlePanel.add(new JLab("Boarding Time"));
		boardingTitlePanel.add(new JLab("Seat No."));

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
		sidePanel.add(new JLab(new ImageIcon(iconTranscoder.getImage())));
		sidePanel.add(sideFlight);
		sidePanel.add(sideName);
		sidePanel.add(sideTo);
		sidePanel.add(sideDate);
		sidePanel.add(sideSeatNo);

		// 待实现JLabel.CENTER全局化，可以@Override JLabel类

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

	private static class JLab extends JLabel {
		public JLab() {
			this.setHorizontalAlignment(JLabel.CENTER);
		}

		public JLab(String text) {
			super(text, JLabel.CENTER);
		}

		public JLab(Icon image) {
			super(image, JLabel.CENTER);
		}
	}

	@Override
	public void syncPage() {
		/*DAO.setCustomer(SERVICE.LoginByCardId("140109200010204817"));
		DAO.setOrder(SERVICE.getOrder(1000111));
		DAO.setFlight(SERVICE.getFlight(DAO.getOrder().getFlightId()));
		DAO.setSeatClass("First");*/
		String[] dates = DAO.getFlight().getTime().split(" ");
		String[] times = dates[3].split(":");
		String[] names = DAO.getCustomer().getName().split(" ");

		infoLabel.setText(DAO.getFlight().getFromCity() + " Airport");
		flight.setText(DAO.getFlight().getFlightId() + " / " + dates[2] + dates[1] + " / " + DAO.getSeatClass());
		name.setText(DAO.getCustomer().getName());
		cityLabel.setText("From " + DAO.getFlight().getFromCity() + " To " + DAO.getFlight().getToCity());
		gate.setText(DAO.getFlight().getGateId() + "");
		boardingTime.setText(times[0] + times[1]); // 待修改，向前提前30分钟
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
		return "Exit";
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
