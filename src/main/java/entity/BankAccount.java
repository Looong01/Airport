package entity;

import java.io.Serializable;

/**
 * Pojo class {@code BankAccount}
 *
 * <p> This class provides the entity about bank accounts' basic information
 * Also,it has the method to deposit, withdraw and check balance.
 *
 * @author Chenyang He
 * @author Hao Sun
 * @author Ziyao Wang
 * @version 1.5
 *
 */
public class BankAccount implements Serializable {
    private int userId;
    private int accNo;
    private String accName;
    private double balance;
    private boolean flagOverdraft = false;
    private final double overdraft = 500.0;

    /**
     * Initialize BankAccount
     * @param userId user ID
     * @param accNo account Number
     * @param accName account Name
     * @param balance balance
     */
    public BankAccount(int userId, int accNo,String accName,double balance){
        this.userId = userId;
        this.accNo=accNo;
        this.accName=accName;
        this.balance=balance;
    }

    /**
     * get user ID
     * @return int
     */
    public int getUserId() {
        return userId;
    }

    /**
     * set user ID
     * @param userId int
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the ID of account
     *
     * @return accNo
     */
    public int getAccNo() {
        return accNo;
    }

    /**
     * set account Number
     * @param accNo int
     */
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    /**
     * Get the name of account
     *
     * @return accName
     */
    public String getAccName() {
        return accName;
    }

    /**
     * set account name
     * @param accName String
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }

    /**
     * Get the balance of account
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the balance of account
     *
     * @param balance the balance that will be set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * is flag
     * @return boolean
     */
    public boolean isFlagOverdraft() {
        return flagOverdraft;
    }

    /**
     * set flag
     * @param flagOverdraft boolean
     */
    public void setFlagOverdraft(boolean flagOverdraft) {
        this.flagOverdraft = flagOverdraft;
    }

    /**
     * get overdraft
     * @return double
     */
    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "userId=" + userId +
                ", accNo=" + accNo +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                '}';
    }

    /**
     * Add the balance of account
     *
     * @param addBalance the balance will be added
     */
    public void deposit(double addBalance){
        if(flagOverdraft){
            System.out.println("The account "+this.getAccName()+" will add balance: "+addBalance);
            if(addBalance>=Math.abs(this.getBalance())){
                this.setBalance(this.getBalance()+addBalance);
                this.flagOverdraft=false;
                System.out.println("Your bill has been paid off, Remaining balance: "+this.getBalance());
            }
            else{
                this.setBalance(this.getBalance()+addBalance);
                System.out.println("You still owe money: "+Math.abs(this.getBalance()));
            }
        }
        else{
            System.out.println("The account "+this.getAccName()+" will add balance: "+addBalance);
            this.setBalance(this.getBalance()+addBalance);
        }
    }

    /**
     * Reduce the balance of account
     *
     * @param withdrawBalance the balance will be reduced
     * @return true if success
     */
    public boolean withdraw(double withdrawBalance){
        if(flagOverdraft){
            System.out.println("The account "+this.getAccName()+" will reduce balance: "+withdrawBalance);
            this.setBalance(this.getBalance()-withdrawBalance);
            System.out.println("You have owen money: "+Math.abs(this.getBalance()));
        }
        else{
            if(withdrawBalance>=this.getBalance()){
                if(withdrawBalance-this.getBalance()>this.overdraft){
                    System.out.println("You cannot exceed your quota: "+this.overdraft);
                    return false;
                }
                this.setBalance(this.getBalance()-withdrawBalance);
                this.flagOverdraft=true;
                System.out.println("You have owen money: "+Math.abs(this.getBalance()));
            }
            else{
                this.setBalance(this.getBalance()-withdrawBalance);
                System.out.println("Remaining balance: "+this.getBalance());
            }
        }
        return true;
    }

    /**
     * Check the balance of account
     *
     * @return the balance of the account
     */
    public double checkBalance(){
        if(flagOverdraft){
            System.out.println("The account "+this.getAccName()+" has owen money: "+Math.abs(this.getBalance()));
        }
        else{
            System.out.println("The account "+this.getAccName()+" has balance: "+this.getBalance());
        }
        return this.getBalance();
    }
}