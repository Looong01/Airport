package util.database.entity;

import entity.BankAccount;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

public class BankUtil {
	private final JSONController jsonB = new JSONController("src/main/resources/json/Bank.json");

	public boolean addAccount(BankAccount account) {
		if (findAccount(account.getAccNo()) != null) {
			System.out.println("ID already exists");
			return false;
		}
		List<BankAccount> accounts = jsonB.readArray(BankAccount.class);
		if(accounts == null)
			accounts = new ArrayList<>();

		accounts.add(account);
		jsonB.writeArray(accounts);
		return true;
	}

	public BankAccount findAccount(int cardId) {
		List<BankAccount> accounts = jsonB.readArray(BankAccount.class);
		if (accounts == null)
			System.out.println("No account");
		else {
			for (BankAccount account : accounts) {
				if (account.getAccNo() == cardId) {
					return account;
				}
			}
		}
		return null;
	}
}
