package util.database.entity;

import entity.Flight;
import entity.user.Customer;
import util.file.JSONController;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class {@code FlightUtil}
 *
 * <p> This class provides some method that help get some
 * information about flights
 *
 * @author Chenyang He
 * @version 1.2
 *
 */
public class FlightUtil {
    //flight的增，删，改，查，统计数量
    private final JSONController jsonF=new JSONController("src/main/resources/json/Flight.json");

    /**
     * Single add method
     * <p>This method will add the flight in the file</>
     *
     * @param f the flight will be added
     */
    public void addFlight(Flight f) {
        if(this.findFlight(f.getFlightId()) != null) {
            System.out.println("The flight already exists");
        } else {
            List<Flight> flights = jsonF.readArray(Flight.class);
            if(flights == null){
                ArrayList<Flight> ff = new ArrayList<>();
                ff.add(f);
                jsonF.writeArray(ff);
            } else {
                flights.add(f);
                jsonF.writeArray(flights);
            }
        }
    }

    /**
     * Single delete method
     * <p>This method will remove the flight with specified ID</>
     *
     * @return true if success, false if failed
     */
    public boolean removeFlight(int flightId){
        if(this.findFlight(flightId)==null){
            System.out.println("The ID do not exist");
            return false;
        }
        List<Flight> flights=jsonF.readArray(Flight.class);
        if(flights==null){
            System.out.println("No flight");
            return false ;
        }
        flights.removeIf(f -> f.getFlightId() == flightId);
        jsonF.writeArray(flights);
        return true;
    }

    /**
     * update method
     * <p>The method updates customers for flight with specified ID</p>
     * If exist, then delete; if not exist, then append
     * @param flightId flight ID
     * @param customer customer's user ID
     * @return true if success
     */
    public boolean updateFlightCustomers(int flightId, int customer) {
        List<Flight> flights = jsonF.readArray(Flight.class);
        if(flights == null){
            System.out.println("No flight");
            return false;
        }
        for (Flight f : flights) {
            if (f.getFlightId() == flightId) {
                ArrayList<Integer> customers = f.getCustomers();
                for (Integer c : customers) {
                    if (c == customer) { // delete customer
                        customers.remove(c); // 可能有index/Object判别问题
                        f.setCustomers(customers);
                        jsonF.writeArray(flights);
                        return true;
                    }
                }

                // append customer
                customers.add(customer);
                f.setCustomers(customers);
                jsonF.writeArray(flights);
                return true;
            }
        }
        System.out.println("The flight ID not found");
        return false;
    }

    /**
     * choose seat
     * @param flightId flight ID
     * @param seatId seat ID
     * @return true if success
     */
    public boolean updateFlightOccupiedSeat(int flightId, int seatId) {
        List<Flight> flights = jsonF.readArray(Flight.class);
        if(flights == null){
            System.out.println("No flight");
            return false;
        }
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                ArrayList<Integer> occupiedSeats = flight.getOccupiedSeats();
                occupiedSeats.add(seatId);
                flight.setOccupiedSeats(occupiedSeats);
                jsonF.writeArray(flights);
                return true;
            }
        }

        System.out.println("The flight ID not found");
        return false;
    }

    /**
     * Single find method
     * <p>This method will find the flight with specified ID</>
     *
     * @return true if success, false if failed
     */
    public Flight findFlight(int flightId){
        List<Flight> flights=jsonF.readArray(Flight.class);
        if(flights==null){
            System.out.println("No flight");
            return null ;
        }
        for(Flight f:flights){
            if(f.getFlightId()==flightId){
                return f;
            }
        }
        return null;
    }

    /**
     * Count number method
     * <p>This method will return the number of flights in the file</>
     *
     * @return number of flight
     */
    public int getTotalFlight(){
        List<Flight> flights=jsonF.readArray(Flight.class);
        if(flights==null){
            System.out.println("No flight");
            return 0;
        }
        return flights.size();
    }
}
