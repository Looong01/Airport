package gui.staff;

import service.StaffService;
import service.impl.StaffServiceImpl;

public interface Page {
	StaffServiceImpl SERVICE = new StaffServiceImpl();
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
