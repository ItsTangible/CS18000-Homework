package Homework09.Challenge;

import java.util.ArrayList;

public interface Park {
    void addRide(Ride ride);
    void close();
    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor);
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
