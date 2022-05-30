package gui.staff;

import service.StaffService;
import service.impl.StaffServiceImpl;

/**
 * Interface for four staff pages
 *
 * @author Zelong Li
 * @author Ziyao Wang
 * @version 1.5
 */
public interface Page {
	StaffService SERVICE = new StaffServiceImpl();
	/**
	 * get title
	 * @return String
	 */
	String getTitle();

	/**
	 * get label
	 * @return String
	 */
	String getLabel();

	/**
	 * get back button text
	 * @return String
	 */
	default String getBack() {
		return "BACK";
	}

	/**
	 * get continue button text
	 * @return String
	 */
	default String getCont() {
		return "CONTINUE";
	}

	/**
	 * execute before page back
	 * @return true if passed
	 */
	boolean back();

	/**
	 * execute before page continue
	 * @return true if passed
	 */
	boolean cont();

	/**
	 * sync data in page
	 */
	void syncPage();
}