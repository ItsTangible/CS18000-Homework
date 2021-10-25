package Homework09.Challenge;
/**
 * Park Interface
 *
 * An interface holding methods for a Park.
 *
 * @author Ben Winther
 *
 * @version 10/24/2021
 *
 */
import java.util.ArrayList;

public interface Park {
    void addRide(Ride ride) throws WrongRideException;
    void close();
    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;
    double getAdmissionCost();
    double getLand();
    String getName();
    ArrayList<Ride> getRides();
    boolean[] getSeasons();
    boolean isIndoor();
    boolean isOutdoor();
    void removeRide(Ride ride);
    void setAdmissionCost(double admissionCost);
    void setName(String name);
    void setSeasons(boolean[] seasons);
}