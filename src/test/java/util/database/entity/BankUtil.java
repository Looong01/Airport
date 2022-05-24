package util.database.entity;

import entity.BankAccount;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code BankUtil}
 *
 * The class provides methods to control Bank.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class BankUtil extends DataBaseUtil {
	public BankUtil() {
		super("src/main/resources/json/Bank.json");
	}

	@Override
	public Object get(String cardId) {
		List<BankAccount> accounts = controller.readArray(BankAccount.class);
		if (accounts == null)
			fail("No account");
		for (BankAccount account : accounts) {
			if (account.getAccNo() == Integer.parseInt(cardId))
				return account;
		}
		return null;
	}

	@Override
	public void add(Object o) {
		BankAccount account = (BankAccount) o;
		if (get(account.getAccNo() + "") != null)
			fail("ID already exists");

		List<BankAccount> accounts = controller.readArray(BankAccount.class);
		if(accounts == null)
			accounts = new ArrayList<>();

		accounts.add(account);
		controller.writeArray(accounts);
	}
}
