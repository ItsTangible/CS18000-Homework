package Homework09.Challenge;

import java.util.ArrayList;
/**
 * Amusement Park Class
 *
 * A class representing an Amusement Park.
 * Each amusement park has a name, admission cost, amount of land, and a list of
 * rides. The class also contains methods for managing all these variables and
 * remembering if the park contains indoor and outdoor land, an arcade, and bowling.
 *
 * @author Ben Winther
 *
 * @version 10/24/2021
 *
 */
public class AmusementPark implements Park {

    // The name of the amusement park
    private String name;

    // The admission cost of the amusement park
    private double admissionCost;

    // The amount of land in the amusement park
    private double land;

    // The list of rides in the amusement park
    private ArrayList<Ride> rides;

    // Whether or not the amusement park has an indoor component
    private boolean indoor;

    // Whether or not the amusement park has an outdoor component
    private boolean outdoor;

    // Whether or not the amusement park has an arcade
    private boolean arcade;

    // Whether or not the amusement park has bowling
    private boolean bowling;

    // Whether or not the amusement park is open during each of the seasons
    private boolean[] seasons;

    /*
     * Constructs a newly allocated AmusementPark object with the field values
     * specified by the input parameters
     */
    public AmusementPark(String name, double admissionCost, double land,
                         ArrayList<Ride> rides, boolean indoor, boolean outdoor,
                         boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;

    }

    /*
     * Adds a new ride to the end of the list of rides in the amusement park, an
     * amusement park can only have rollercoasters so throw a WrongRideException
     * if the ride to be added is not a rollercoaster
     */
    @Override
    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Rollercoaster)) {
            throw new WrongRideException("An amusement park can only have rollercoaster rides");
        } else {
            rides.add(ride);
        }
    }

    /*
     * Closes the park by setting name to an empty string, admissionCost and land
     * to 0, rides and seasons to null, and indoor, outdoor, arcade, and bowling
     * to false
     */
    @Override
    public void close() {
        this.name = "";
        this.admissionCost = 0;
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.arcade = false;
        this.bowling = false;
    }

    // Enlarges the amusement park by adding a certain amount of land to the park
    @Override
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) throws SpaceFullException {
        if (land + addedLand > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park");
        } else {
            this.land += addedLand;
            if (!this.indoor) this.indoor = addedIndoor;
            if (!this.outdoor) this.outdoor = addedOutdoor;
        }
    }

    // Returns the admission cost of the amusement park
    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    // Returns the amount of land the amusement park covers in acres
    @Override
    public double getLand() {
        return land;
    }

    // Returns the name of the amusement park
    @Override
    public String getName() {
        return this.name;
    }

    // Returns the list of rides in the amusement park
    @Override
    public ArrayList<Ride> getRides() {
        return this.rides;
    }

    /*
     * Returns the array representing the seasons when the amusement park is open
     * and closed
     */
    @Override
    public boolean[] getSeasons() {
        return this.seasons;
    }

    // Returns whether or not the amusement park has an arcade
    public boolean isArcade() {
        return this.arcade;
    }

    //Returns whether or not the amusement park has bowling
    public boolean isBowling() {
        return this.bowling;
    }

    // Returns whether or not the amusement park has an indoor component
    @Override
    public boolean isIndoor() {
        return this.indoor;
    }

    // Returns whether or not the amusement park has an outdoor component
    @Override
    public boolean isOutdoor() {
        return this.outdoor;
    }

    /*
     * Modifies the ride given as input to have the name, color, minHeight,
     * maxRiders, and simulated boolean provided as parameters
     */
    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders,
                           boolean newSimulated) {
        rides.set(rides.indexOf(ride), new Rollercoaster(newName, newColor,
                newMinHeight, newMaxRiders, newSimulated));
    }

    // Removes the ride given as an input parameter from the list of rides
    @Override
    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    // Sets the admission cost instance variable to the value given as a parameter
    @Override
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    // Sets the arcade instance variable to the arcade boolean given as a parameter
    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    // Sets the bowling instance variable to the bowling boolean given as a parameter
    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    // Sets the name instance variable to the String given as a parameter
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Sets the seasons instance variable to the boolean array given as a parameter
    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
}