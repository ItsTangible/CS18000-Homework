package Homework09.Challenge;

import java.util.ArrayList;

public class WaterPark implements Park {

    // The name of the water park
    private String name;

    // The admission cost of the water park
    private double admissionCost;

    // The amount of land in the water park
    private double land;

    // The list of rides in the water park
    private ArrayList<Ride> rides;

    // Whether or not the water park has an indoor component
    private boolean indoor;

    // Whether or not the water park has an outdoor component
    private boolean outdoor;

    // Whether or not the water park has a lazyRiver
    private boolean lazyRiver;

    // Whether or not the water park has a wavePool
    private boolean wavePool;

    // Whether or not the water park is open during each of the seasons
    private boolean[] seasons;

    /*
     * Constructs a newly allocated WaterPark object with the field values
     * specified by the input parameters
     */
    public WaterPark(String name, double admissionCost, double land,
                     ArrayList<Ride> rides, boolean indoor, boolean outdoor,
                     boolean lazyRiver, boolean wavePool, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;

    }

    /*
     * Adds a new ride to the end of the list of rides in the amusement park, an
     * amusement park can only have waterslides so throw a WrongRideException if
     * the ride to be added is not a waterslide
     */
    @Override
    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Waterslide)) {
            throw new WrongRideException("An amusement park can only have rollercoaster rides");
        } else {
            rides.add(ride);
        }
    }

    /*
     * Closes the park by setting name to an empty string, admissionCost and land
     * to 0, rides and seasons to null, and indoor, outdoor, lazyRiver, and
     * wavePool to false
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
        this.lazyRiver = false;
        this.wavePool = false;
    }

    // Enlarges the water park by adding a certain amount of land to the park
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

    // Returns the admission cost of the water park
    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    // Returns the amount of land the water park covers in acres
    @Override
    public double getLand() {
        return land;
    }

    // Returns the name of the water park
    @Override
    public String getName() {
        return this.name;
    }

    // Returns the list of rides in the water park
    @Override
    public ArrayList<Ride> getRides() {
        return this.rides;
    }

    /*
     * Returns the array representing the seasons when the water park is open
     * and closed
     */
    @Override
    public boolean[] getSeasons() {
        return this.seasons;
    }

    // Returns whether or not the water park has a lazyRiver
    public boolean isLazyRiver() {
        return this.lazyRiver;
    }

    //Returns whether or not the water park has a wavePool
    public boolean isWavePool() {
        return this.wavePool;
    }

    // Returns whether or not the water park has an indoor component
    @Override
    public boolean isIndoor() {
        return this.indoor;
    }

    // Returns whether or not the water park has an outdoor component
    @Override
    public boolean isOutdoor() {
        return this.outdoor;
    }

    /*
     * Modifies the ride given as input to have the name, color, minHeight,
     * maxRiders, and splashDepth double provided as parameters
     */
    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders,
                           double newSplashDepth) {
        rides.set(rides.indexOf(ride), new Waterslide(newName, newColor,
                newMinHeight, newMaxRiders, newSplashDepth));
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

    // Sets the lazyRiver instance variable to the lazyRiver boolean given as a parameter
    public void setArcade(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    // Sets the lazyRiver instance variable to the wavePool boolean given as a parameter
    public void setBowling(boolean wavePool) {
        this.wavePool = wavePool;
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
