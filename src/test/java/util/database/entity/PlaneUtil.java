package util.database.entity;

import entity.Plane;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code PlaneUtil}
 *
 * The class provides methods to control Plane.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class PlaneUtil extends DataBaseUtil {
    public PlaneUtil() {
        super("src/main/resources/json/Plane.json");
    }

    @Override
    public Object get(String planeId) {
        List<Plane> planes = controller.readArray(Plane.class);
        if(planes == null)
            fail("No plane");
        for(Plane a : planes){
            if(a.getPlaneId().equals(planeId))
                return a;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Plane a = (Plane) o;
        if(get(a.getPlaneId() + "") != null)
            fail("The plane ID already exists");
        List<Plane> planes = controller.readArray(Plane.class);
        if(planes == null)
            planes = new ArrayList<>();
        planes.add(a);
        controller.writeArray(planes);
    }
}
