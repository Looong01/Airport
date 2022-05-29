package util.gui;

import java.awt.GridBagConstraints;

/**
 * The class extends GridBagConstraints to enriches it by adding additional methods
 * @author Ziyao Wang
 * @version 1.2
 */
public class GridBagLayoutConstraints extends GridBagConstraints {
	/**
	 * constructor for GridBagLayoutConstraints
	 */
	public GridBagLayoutConstraints () {
		this.fill = GridBagConstraints.BOTH; // if gridbag is larger than the component in it, enlarge component
	}

	/**
	 * The method sets constraints for GridBagConstraints
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param width width
	 * @param height height
	 */
	public void setConstraints (int x, int y, int width, int height) {
		this.gridx = x;
		this.gridy = y;
		this.gridwidth = width;
		this.gridheight = height;
	}
}
