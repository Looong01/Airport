package util.database.entity;

import entity.Flight;
import util.database.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Utility class {@code FlightUtil}
 *
 * The class provides methods to control Flight.json
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class FlightUtil extends DataBaseUtil {
    public FlightUtil() {
        super("src/main/resources/json/Flight.json");
    }

    @Override
    public Object get(int flightId) {
        List<Flight> flights=controller.readArray(Flight.class);
        if(flights==null)
            fail("No flight");

        for(Flight f:flights){
            if(f.getFlightId()==flightId)
                return f;
        }
        return null;
    }

    @Override
    public void add(Object o) {
        Flight f = (Flight) o;
        if(get(f.getFlightId()) != null)
            fail("The flight already exists");
        List<Flight> flights = controller.readArray(Flight.class);
        if(flights == null)
            flights = new ArrayList<>();
        flights.add(f);
        controller.writeArray(flights);
    }

    /**
     * update method
     * <p>The method updates customers for flight with specified ID</p>
     * If exist, then delete; if not exist, then append
     * @param flightId flight ID
     * @param customer customer's user ID
     */
    void updateFlightCustomers(int flightId, int customer) {
        List<Flight> flights = controller.readArray(Flight.class);
        if(flights == null){
            fail("No flight");
        }
        for (Flight f : flights) {
            if (f.getFlightId() == flightId) {
                ArrayList<Integer> customers = f.getCustomers();
                for (Integer c : customers) {
                    if (c == customer) { // delete customer
                        customers.remove(c); // 可能有index/Object判别问题
                        f.setCustomers(customers);
                        controller.writeArray(flights);
                        return;
                    }
                }

                // append customer
                customers.add(customer);
                f.setCustomers(customers);
                controller.writeArray(flights);
                return;
            }
        }
        fail("The flight ID not found");
    }

    /**
     * choose seat
     * @param flightId flight ID
     * @param seatId seat ID
     */
    void updateFlightOccupiedSeat(int flightId, int seatId) {
        if (seatId == -1)
            return;
        List<Flight> flights = controller.readArray(Flight.class);
        if(flights == null){
            fail("No flight");
        }
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                ArrayList<Integer> occupiedSeats = flight.getOccupiedSeats();
                occupiedSeats.add(seatId);
                flight.setOccupiedSeats(occupiedSeats);
                controller.writeArray(flights);
                return;
            }
        }

        fail("The flight ID not found");
    }
}
