package util.database.entity;

import entity.user.Staff;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code StaffUtil}
 *
 * The class provides methods to control Staff.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class StaffUtil extends DataBaseUtil {
    public StaffUtil() {
        super("src/main/resources/json/Staff.json");
    }

    @Override
    public Object get(String userId) {
        List<Staff> staffs=controller.readArray(Staff.class);
        if(staffs==null)
            fail("No staff");
        for(Staff s : staffs){
            if(s.getUserId() == Integer.parseInt(userId))
                return s;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Staff s = (Staff) o;
        if(get(s.getUserId() + "") != null)
            fail("The ID has existed");
        List<Staff> staffs=controller.readArray(Staff.class);
        if(staffs==null)
            staffs = new ArrayList<>();
        staffs.add(s);
        controller.writeArray(staffs);
    }
}
