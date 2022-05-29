package gui.staff;

import service.StaffService;
import service.impl.StaffServiceImpl;

/**
 * Interface for four staff pages
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public interface Page {
	StaffService SERVICE = new StaffServiceImpl();
	String getTitle();
	String getLabel();
	default String getBack() {
		return "BACK";
	}
	default String getCont() {
		return "CONTINUE";
	}
	boolean back();
	boolean cont();
	void syncPage();
}
