package gui.customer;

import gui.customer.dao.CustomerDAO;
import service.BankService;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import service.impl.BankServiceImpl;

public interface Page {
	CustomerService SERVICE = new CustomerServiceImpl();
	CustomerDAO DAO = new CustomerDAO();
	BankService BANK = new BankServiceImpl();

	String getTitle();
	String getLabel();
	default String getBack() {
		return "Back";
	}
	default String getCont() {
		return "Continue";
	}
	boolean back();
	boolean cont();
	void syncPage();
}
