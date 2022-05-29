package service.impl;


import entity.BankAccount;
import service.BankService;
import util.file.JSONController;

import java.util.List;


/**
 * Service class {@code BankService}
 *
 * <p> This class will simulate the bank's actions
 *
 * @author Chenyang He
 * @author Hao Sun
 * @version 1.4
 *
 */
public class BankServiceImpl implements BankService {
    private final JSONController bankController = new JSONController("src/main/resources/json/Bank.json");

    /**
     * This method helps to check the bank account.
     *
     * @param cardId The card ID of the customer.
     * @return True if existed, False if not
     */
    @Override
    public boolean checkBankCard(int cardId) {
        List<BankAccount> bankAccounts= bankController.readArray(BankAccount.class);
        for(BankAccount b : bankAccounts) {
            if(b.getAccNo()==cardId)
                return true;
        }
        return false;
    }

    /**
     * This method helps to pay for form bank
     *
     * @param cardId The card ID of the customer.
     * @param balance The money will be reduced
     * @return True if successful, False if not
     */
    @Override
    public boolean pay(int cardId,double balance) {
        if(!checkBankCard(cardId)) {
            System.out.println("The account does not exist.");
            return false;
        }
        List<BankAccount> bankAccounts= bankController.readArray(BankAccount.class);
        for(BankAccount b:bankAccounts){
            if(b.getAccNo()==cardId){
                if(b.withdraw(balance)){
                    bankController.writeArray(bankAccounts);
                    return true;
                }
            }
        }
        return false;
    }
}
