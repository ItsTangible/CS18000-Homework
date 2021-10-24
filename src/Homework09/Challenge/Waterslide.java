package Homework09.Challenge;

public class Waterslide extends Ride {

    // The splash depth of the waterslide in feet
    private double splashDepth;

    /*
     * Constructs a newly allocated Waterslide object with the field values specified
     * by the input parameters
     */
    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    // Returns the depth at the bottom of the waterslide in feet
    public double getSplashDepth() {
        return splashDepth;
    }

    // Sets the splashDepth instance variable to the value given as a parameter
    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    /*
     * Overrides equals() method in Ride. Determines whether or not the object given as
     * a parameter is equal to this waterslide. true is returned if the specified object
     * is an instance of Waterslide and the name, color, minHeight, maxRiders, and
     * splashDepth of the given waterslide are equal to the name, color, minHeight,
     * maxRiders, and simulated value of this waterslide
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Waterslide)) {
            return false;
        }
        if (!super.equals(o)) return false;
        Waterslide temp = (Waterslide) o;
        return this.getSplashDepth() == temp.getSplashDepth();
    }

    /*
     * Overrides toString() method in Ride. Returns the String representation of this
     * waterslide. This includes the name, color, minHeight, maxRiders, and splashDepth
     * separated by a new line each with labels and units when necessary
     */
    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n"
                + "Color: " + this.getColor() + "\n"
                + "MinHeight: " + this.getMinHeight() + " inches\n"
                + "MaxRiders:" + this.getMaxRiders() + "\n"
                + "SplashDepth: " + getSplashDepth();
    }
}
