package service;
import java.util.ArrayList;

/**
 * Service class {@code StaffService}
 *
 * <p> This class provides an interface for methods required for staff side actions.
 * The function of these methods is described in detail in this interface's implement, class StaffServiceImpl
 *
 * @author Hao Sun & Chenyang He
 * @version 1.1
 *
 */

public interface StaffService {

    boolean loginByPasswd(String cardId,String passwd);

    boolean checkUser(String cardId, int flightId);

    int[] checkFlight(int flightId);

    ArrayList<String> checkOrder(int flightId);

    void logout();
}