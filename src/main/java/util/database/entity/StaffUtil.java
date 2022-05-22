package util.database.entity;

import entity.user.Staff;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class {@code StaffUtil}
 *
 * <p> This class provides some method that help get some
 * information about staffs
 *
 * @author Chenyang He
 * @version 1.2
 *
 */
public class StaffUtil {

    //最底层的基础方法，不要动，其他的联合修改都是调用这次底层方法
    //staff的增，删，改，查，统计数量
    private final JSONController jsonS=new JSONController("src/main/resources/json/Staff.json");

    /**
     * Single add method
     * <p>This method will add the single staff in the file</>
     *
     * @param s the staff will be added
     *
     */
    public void addStaff(Staff s){
        if(this.findStaff(s.getUserId())!=null){
            System.out.println("The ID has existed");
            return;
        }
        List<Staff> staffs=jsonS.readArray(Staff.class);
        if(staffs==null){
            ArrayList<Staff> sTemp=new ArrayList<>();
            sTemp.add(s);
            jsonS.writeArray(sTemp);
            return ;
        }
        staffs.add(s);
        jsonS.writeArray(staffs);
    }

    /**
     * This method will remove the staff with specified
     * userId
     *
     * @return true if success, false if failed
     */
    public boolean removeStaff(int userId){
        if(this.findStaff(userId)==null){
            System.out.println("The ID do not exist!");
            return false;
        }
        List<Staff> staffs=jsonS.readArray(Staff.class);
        if(staffs==null){
            System.out.println("No staff exist!");
            return false;
        }
        staffs.removeIf(s -> s.getUserId()==userId);
        jsonS.writeArray(staffs);
        return true;
    }

    /**
     * This method will update the password
     * of the staff with specified userId
     *
     * @return true if success, false if failed
     */
    public boolean updateStaffPasswd(int userId,String passwd){
        if(this.findStaff(userId)==null){
            System.out.println("The ID do not exist!");
            return false;
        }
        List<Staff> staffs=jsonS.readArray(Staff.class);
        if(staffs==null){
            System.out.println("No staff exist!");
            return false;
        }
        for(Staff s: staffs){
            if(s.getUserId()==userId){
                s.setPasswd(passwd);
                return true;
            }
        }
        return false;
    }

    /**
     * This method will find the staffs with specified
     * userId
     *
     * @param userId ID will be used
     * @return staff
     */
    public Staff findStaff(int userId){
        List<Staff> staffs=jsonS.readArray(Staff.class);
        if(staffs==null){
            System.out.println("No staff");
            return null;
        }
        for(Staff s : staffs){
            if(s.getUserId()==userId){
                return s;
            }
        }
        return null;
    }


    /**
     * This method will return the number of staffs
     * in the file
     *
     * @return number of customer
     */
    public int getTotalCustomer() {
        List<Staff> staffs=jsonS.readArray(Staff.class);
        if(staffs==null){
            return 0;
        }
        return staffs.size();
    }
}
