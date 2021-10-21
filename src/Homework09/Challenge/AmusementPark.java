package Homework09.Challenge;

public class AmusementPark implements Park {

    // The name of the amusement park
    private String name;

    // The admission cost of the amusement park
    private double admissionCost;

    // The amount of land in the amusement park
    private double land;

    // The list of rides in the amusement park
    private Ride[] rides;

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
                         Ride[] rides, boolean indoor, boolean outdoor,
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
    public void addRide(Ride ride) {

    }

    /*
     * Closes the park by setting name to an empty string, admissionCost and land
     * to 0, rides and seasons to null, and indoor, outdoor, arcade, and bowling
     * to false
     */
    @Override
    public void close() {

    }

    // Enlarges the amusement park by adding a certain amount of land to the park
    @Override
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) {

    }

    // Returns the admission cost of the amusement park
    @Override
    public double getAdmissionCost() {
        return 0;
    }

    // Returns the amount of land the amusement park covers in acres
    @Override
    public double getLand() {
        return 0;
    }

    // Returns the name of the amusement park
    @Override
    public String getName() {
        return null;
    }

    // Returns the list of rides in the amusement park
    @Override
    public Ride[] getRides() {
        return new Ride[0];
    }

    /*
     * Returns the array representing the seasons when the amusement park is open
     * and closed
     */
    @Override
    public boolean[] getSeasons() {
        return new boolean[0];
    }

    // Returns whether or not the amusement park has an arcade
    public boolean isArcade() {
        return false;
    }

    //Returns whether or not the amusement park has bowling
    public boolean isBowling() {
        return false;
    }

    // Returns whether or not the amusement park has an indoor component
    @Override
    public boolean isIndoor() {
        return false;
    }

    // Returns whether or not the amusement park has an outdoor component
    @Override
    public boolean isOutdoor() {
        return false;
    }

    /*
     * Modifies the ride given as input to have the name, color, minHeight,
     * maxRiders, and simulated boolean provided as parameters
     */
    public void modifyRide(Ride ride, String newName, String newColor,
                           int newMinHeight, int newMaxRiders,
                           boolean newSimulated) {

    }

    // Removes the ride given as an input parameter from the list of rides
    @Override
    public void removeRide(Ride ride) {

    }

    // Sets the admission cost instance variable to the value given as a parameter
    @Override
    public void setAdmissionCost(double admissionCost) {

    }

    // Sets the arcade instance variable to the arcade boolean given as a parameter
    public void setArcade(boolean arcade) {

    }

    // Sets the bowling instance variable to the bowling boolean given as a parameter
    public void setBowling(boolean bowling) {

    }

    // Sets the name instance variable to the String given as a parameter
    @Override
    public void setName(String name) {

    }

    // Sets the seasons instance variable to the boolean array given as a parameter
    @Override
    public void setSeasons(boolean[] seasons) {

    }
}
