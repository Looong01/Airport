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
	boolean checkBankCard(int cardId);
	boolean pay(int cardId, double balance);
}
