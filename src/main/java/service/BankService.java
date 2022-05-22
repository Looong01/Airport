package service;

public interface BankService {
	boolean checkBankCard(int cardId);
	boolean pay(int cardId, double balance);
}
