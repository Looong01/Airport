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
 * @author Zelong Li
 * @version 1.5
 */
public interface Page {
	CustomerService SERVICE = new CustomerServiceImpl();
	CustomerDAO DAO = new CustomerDAO();
	BankService BANK = new BankServiceImpl();

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
