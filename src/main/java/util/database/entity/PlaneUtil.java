package util.database.entity;

import entity.Plane;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class {@code AirportUtil}
 *
 * <p>This class interacts Airplane.json with {@code Airplane}</p>
 *
 * @author Chenyang He
 * @author Ziyao Wang
 * @version 5.0
 */
public class PlaneUtil {
    //staff的增，删，改，查(有两个，一个判断存在)，统计数量
    private final JSONController jsonA = new JSONController(System.getProperty("user.dir") + "/src/main/resources/json/Plane.json");

    /**
     * Single add method
     * <p>This method will add the single airplane in the file</p>
     *
     * @param a the airplane object to be added
     */
    public boolean addPlane(Plane a) {
        if(this.findPlane(a.getPlaneId()) != null) {
            System.out.println("The plane ID already exists");
            return false;
        }
        List<Plane> planes = jsonA.readArray(Plane.class);
        if(planes == null)
            planes = new ArrayList<>();
        planes.add(a);
        jsonA.writeArray(planes);
        return true;
    }

    /**
     * Single delete method
     * <p>This method will remove the airport with specified userId</>
     *
     * @return true if success, false if failed
     */
    public boolean removePlane(int planeID) {
        if(this.findPlane(planeID) == null){
            System.out.println("The plane do not exist!");
            return false;
        }
        List<Plane> planes =jsonA.readArray(Plane.class);
        if(planes ==null){
            System.out.println("No airplanes in the airport");
            return false;
        }
        planes.removeIf(f -> f.getPlaneId() == planeID);
        jsonA.writeArray(planes);
        return true;
    }

    /**
     * Single find method
     * <p>This method will find the airplane in the file</>
     *
     * @param planeID the ID to be used
     * @return Airplane
     *
     */
    public Plane findPlane(int planeID) {
        List<Plane> planes = jsonA.readArray(Plane.class);
        if(planes == null){
            System.out.println("No plane");
            return null;
        }
        for(Plane a : planes){
            if(a.getPlaneId() == planeID){
                return a;
            }
        }
        return null;
    }
}
