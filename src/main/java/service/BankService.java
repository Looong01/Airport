package service;

/**
 * Service Interface {@code BankService}
 *
 * <p> This interface is used to provide the
 * service for bank.
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public interface BankService {
	/**
	 * This method helps to check the bank account.
	 *
	 * @param cardId The card ID of the customer.
	 * @return True if existed, False if not
	 */
	boolean checkBankCard(int cardId);
	/**
	 * This method helps to pay for form bank
	 *
	 * @param cardId The card ID of the customer.
	 * @param balance The money will be reduced
	 * @return True if successful, False if not
	 */
	boolean pay(int cardId, double balance);
}
