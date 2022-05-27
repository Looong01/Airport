package gui.customer;

import gui.customer.dao.CustomerDAO;
import service.BankService;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import service.impl.BankServiceImpl;

/**
 * Interface for six customer pages
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public interface Page {
	CustomerService SERVICE = new CustomerServiceImpl();
	CustomerDAO DAO = new CustomerDAO();
	BankService BANK = new BankServiceImpl();

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
