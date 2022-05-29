package entity.user;

import entity.User;

import java.util.ArrayList;

/**
 * Entity class {@code Customer}
 *
 * <p> This class provides the entity about customers' basic information.
 * Class {@code User} is the parent of this class.
 *
 * @author Loong Lee
 * @author Shuzhou Zhao
 * @version 1.1
 *
 */
public class Customer extends User {
    private String cardId;
    private String sex;
    private String tel;
    private ArrayList<String> orders = new ArrayList<>();

    /**
     * The default constructor of the Customer
     */
    public Customer(){

    }

    /**
     * The constructor of the Customer
     * @param userId The ID of the customer
     * @param name The name of the customer
     * @param cardId The card ID of the customer
     * @param sex The sex of the customer
     * @param tel The telephone number of the customer
     */
    public Customer(int userId,String name,String cardId,String sex,String tel,String email) {
        this.userId=userId;
        this.name=name;
        this.type=2;
        this.cardId=cardId;
        this.sex=sex;
        this.tel=tel;
        this.email=email;
    }


    /**
     * Get the card ID of the customer
     *
     * @return cardId
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Set the card ID of the customer
     *
     * @param cardId the card ID of the customer
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * Get the sex of the customer
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the sex of the customer
     *
     * @param sex the sex of the customer
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get the telephone number of the customer
     *
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set the telephone number of the customer
     *
     * @param tel the telephone number of the customer
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Get the order list of the customer
     *
     * @return orders
     */
    public ArrayList<String> getOrders() {
        return orders;
    }

    /**
     * Set the order list of the customer
     *
     * @param orders the order list of the customer
     */
    public void setOrders(ArrayList<String> orders) {
        this.orders = orders;
    }

    /**
     * get user ID
     * @return int
     */
    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", cardId='" + cardId + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", order=" + orders +
                '}';
    }
}
