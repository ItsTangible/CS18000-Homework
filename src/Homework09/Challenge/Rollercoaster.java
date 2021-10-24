package Homework09.Challenge;

import java.util.Objects;

public class Rollercoaster extends Ride {

    // Whether or not the ride is a simulation
    private boolean simulated;

    /*
     * Constructs a newly allocated Rollercoaster object with the field values
     *  specified by the input parameters
     */
    public Rollercoaster(String name, String color, int minHeight,
                         int maxRiders, boolean simulated) {
        super(name, color,minHeight,maxRiders);
        this.simulated = simulated;
    }

    // Returns whether or not the rollercoaster is simulated
    public boolean isSimulated() {
        return simulated;
    }

    // Sets the simulated instance variable to the boolean given as a parameter
    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    /*
     * Overrides equals() method in Ride. Determines whether or not the object
     * given as a parameter is equal to this rollercoaster. true is returned if
     * the specified object is an instance of Rollercoaster and the name, color,
     * minHeight, maxRiders, and simulated value of the given rollercoaster are
     * equal to the name, color, minHeight, maxRiders, and simulated value of
     * this rollercoaster.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rollercoaster)) {
            return false;
        }
        if (!super.equals(o)) return false;
        Rollercoaster temp = (Rollercoaster) o;
        return isSimulated() == temp.isSimulated();
    }

    /*
     * Overrides toString() method in Ride. Returns the String representation of
     * this rollercoaster. This includes the name, color, minHeight, maxRiders,
     * and simulated value separated by a new line each with labels and units
     * when necessary
     */
    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n"
                + "Color: " + this.getColor() + "\n"
                + "MinHeight: " + this.getMinHeight() + " inches\n"
                + "MaxRiders:" + this.getMaxRiders() + "\n"
                + "Simulated: " + isSimulated();
    }
}
