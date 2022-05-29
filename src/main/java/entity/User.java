package entity;

import java.io.Serializable;

/**
 * Entity class {@code User}
 *
 * <p> This class provides the entity about users' basic information.
 * There are two types of the user: customer, staff.
 * User is the parent class of these two classes
 * Customer's type is 1, and Staff's type is 2
 *
 * @author Chenyang He
 * @author Hao Sun
 * @version 1.0
 *
 */
public abstract class User implements Serializable {
    protected int userId;
    protected String name;
    protected int type;
    protected String email;

    /**
     * Get the ID of the user
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the ID of the user
     *
     * @param userId the ID of the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the name of the user
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user
     *
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the type of the user
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of the user
     *
     * @param type the type number of the user,
     *             can only be 1 or 2
     */
    public void setType(int type) {
        if(type==1) {
            this.type = type;
            return;
        }
        else if(type==2){
            this.type = type;
            return;
        }
        System.out.println("Invalid type of user.");
    }

    /**
     * get email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The toString() method for the user
     *
     */
    @Override
    public String toString() {
        String type;
        if(this.getType()==1){
            type="Customer";
        }else {
            type="Staff";
        }
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", type=" + type +
        '}';
    }
}
