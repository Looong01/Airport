package gui.customer.page;

import gui.customer.Page;
import gui.customer.Template;
import util.gui.BufferedImageTranscoder;
import util.gui.Display;

import javax.swing.*;
import java.awt.*;

/**
 * This class displays a GUI for customer to choose extra options like special seats or gourmet menu
 * @author wzy
 * @version 3.0
 */

public class ChooseFood extends JPanel implements Page {
	private String selectedFood;
	private int due = 0;
	private final String foodSVG = "src/main/resources/svg/egg";
	private final BufferedImageTranscoder foodTranscoder = new BufferedImageTranscoder(foodSVG + ".svg",60 * Template.getP(),60 * Template.getP());
	private final BufferedImageTranscoder sFoodTranscoder = new BufferedImageTranscoder(foodSVG + "-solid.svg",60 * Template.getP(),60 * Template.getP());
	private final BufferedImageTranscoder fFoodTranscoder = new BufferedImageTranscoder(foodSVG + "-fried.svg",60 * Template.getP(),60 * Template.getP());

	public ChooseFood() {
		this.setLayout(new GridLayout(3, 2));

		JFood food1 = new JFood("Standard +$0");
		JFood food2 = new JFood("Vegetarian +$0");
		JFood food3 = new JFood("Halal +$0");
		JFood food4 = new JFood("Light Meal +$5");
		JFood food5 = new JFood("Gourmet Menu +$15");
		JFood food6 = new JFood("Chef's Special +$20");

		// buttonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(food1);
		group.add(food2);
		group.add(food3);
		group.add(food4);
		group.add(food5);
		group.add(food6);

		this.add(food1);
		this.add(food2);
		this.add(food3);
		this.add(food4);
		this.add(food5);
		this.add(food6);

		Display.setPageFont(this);
	}

	private class JFood extends JRadioButton {
		public JFood(String food) {
			super();
			this.setText(food);
			this.setIcon(new ImageIcon(foodTranscoder.getImage()));
			this.setRolloverIcon(new ImageIcon(sFoodTranscoder.getImage()));
			this.setSelectedIcon(new ImageIcon(fFoodTranscoder.getImage()));
			this.addActionListener(e -> { // actionListener cannot capture deselection from buttongroup
				selectedFood = this.getText().split("\\+")[0].trim();
				due = Integer.parseInt(this.getText().split("\\$")[1]);
				Template.getCont().setText("Due $" + (DAO.getDue() + due));
			});
		}
	}

	@Override
	public void syncPage() {
		Template.getCont().setText("Due $" + DAO.getDue());
	}

	@Override
	public String getTitle() {
		return "Choose Food";
	}

	@Override
	public String getLabel() {
		return "Please choose your food";
	}

	@Override
	public boolean back() {
		return true;
	}

	@Override
	public boolean cont() {
		DAO.getOrder().setFood(selectedFood);
		DAO.setDue(DAO.getDue() + due);
		return true;
	}
}
