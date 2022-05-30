package entity.user;

import entity.User;

/**
 * Entity class {@code Staff}
 *
 * <p> This class provides the entity about staffs' basic information.
 * Class {@code User} is the parent of this class.
 *
 * @author Chenyang He
 * @version 1.0
 *
 */
public class Staff extends User {
    private String passwd;
    private String cardId;

    /**
     * The default constructor of the Staff
     */
    public Staff(){

    }

    /**
     * The constructor of the staff
     * @param cardId The card ID of the staff
     * @param userId The ID of the staff
     * @param name The name of the staff
     * @param passwd The password of the staff
     */
    public Staff(int userId, String name, String cardId, String passwd){
        this.userId=userId;
        this.name=name;
        this.type=2;
        this.passwd=passwd;
        this.cardId=cardId;
    }

    /**
     * Get the card ID of the staff
     *
     * @return cardId
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Set the card ID of the staff
     *
     * @param cardId the card ID of the staff
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * Get the password of the staff
     *
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Set the password of the staff
     *
     * @param passwd the password of the staff
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}