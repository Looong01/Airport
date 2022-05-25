package entity;

import java.io.Serializable;

/**
 * Entity class {@code Airplane}
 *
 * This class defines airplane entity with planeID, seats, and seatNum.
 *
 * @author Ziyao Wang
 * @version 1.5
 *
 */

public class Plane implements Serializable {
    String planeId;
    public final static int seatNum = 50;

    /**
     * The default constructor of the Airplane
     */
    public Plane() {

    }

    public Plane(String planeId) {
        this.planeId = planeId;
    }

    /**
     * Get the plane ID
     * @return planeID
     */
    public String getPlaneId() {
        return planeId;
    }

    /**
     * Set the plane ID
     * @param planeId plane ID
     */
    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                '}';
    }
}
