package Homework09.Challenge;
/**
 * Ride Class
 *
 * A class representing a ride in a park.
 * Each ride has its own name, color, minimum
 * height, and maximum riders
 *
 * @author Ben Winther
 *
 * @version 10/24/2021
 *
 */
public class Ride {

    // The name of the ride
    private String name;

    // The color of the ride
    private String color;

    // The minimum height in inches required to go on this ride
    private int minHeight;

    // The maximum number of people that can go on this ride at once
    private int maxRiders;

    /*
     * Constructs a newly allocated Ride object with name and color set to
     * empty strings and minHeight and maxRiders set to 0
     */
    public Ride() {
        this.name = "";
        this.color = "";
        this.minHeight = 0;
        this.maxRiders = 0;
    }

    /*
     * Constructs a newly allocated Ride object with the field values
     * specified by the input parameters
     */
    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name  = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    // Returns the color of the ride
    public String getColor() {
        return color;
    }

    // Returns the maximum number of people that can go on this ride at once
    public int getMaxRiders() {
        return maxRiders;
    }

    // Returns the minimum height in inches to go on this ride
    public int getMinHeight() {
        return minHeight;
    }

    // Returns the name of the ride
    public String getName() {
        return name;
    }

    // Sets the color instance variable to the String given as a parameter
    public void setColor(String color) {
        this.color = color;
    }

    // Sets the maxRiders instance variable to the value given as a parameter
    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    // Sets the minHeight instance variable to the value given as a parameter
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    // Sets the name instance variable to the String given as a parameter
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Determines whether or not the object given as a parameter is equal
     * to this ride
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Ride)) {
            return false;
        } else {
            Ride temp = (Ride) o;
            String tempName = temp.getName();
            String tempColor = temp.getColor();
            int tempMaxRiders = temp.getMaxRiders();
            int tempMinHeight = temp.getMinHeight();
            return tempColor.equals(this.color) && tempName.equals(this.name)
                    && tempMinHeight == this.minHeight && tempMaxRiders == this.maxRiders;
        }
    }

    /*
     * Returns the String representation of this ride. This includes the name,
     * color, minHeight, and maxRiders separated by a new line each with labels
     * and units when necessary
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Color: " + color + "\n"
                + "MinHeight: " + minHeight + " inches\n"
                + "MaxRiders: " + maxRiders;
    }
}