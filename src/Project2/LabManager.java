package Project2;

public class LabManager {

    // The first lab of this LabManager
    private Lab labOne;

    // The second lab of this LabManager
    private Lab labTwo;

    // The third lab of this LabManager
    private Lab labThree;

    /* Construct a newly allocated LabManager object and
     * instantiate the fields to their respective parameters
     */
    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    // Returns the first lab of this LabManager
    public Lab getLabOne() {
        return labOne;
    }

    // Returns the second lab of this LabManager
    public Lab getLabTwo() {
        return labTwo;
    }

    // Returns the third lab of this LabManager
    public Lab getLabThree() {
        return labThree;
    }

    // Sets the first lab of this LabManager
    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }

    // Sets the second lab of this LabManager
    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }

    // Sets the third lab of this LabManager
    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    /* Returns the total capacity for all three labs. The
     * total capacity is the maximum number of seats occupied
     * if every session for all three labs is booked at full
     * capacity
     */
    public int calculateTotalCapacity() {
        return (labOne.getCapacity() + labTwo.getCapacity() + labThree.getCapacity()) * 2;
    }

    /* Returns the average percentage utilization for all three
     * labs. This is the percentage of seats occupied overall
     * out of the total seats available
     */
    public double calculateTotalUtilization() {
        double labOneCap = labOne.getCapacity();
        double labTwoCap = labTwo.getCapacity();
        double labThreeCap = labThree.getCapacity();

        double labOneUtil = (((labOne.getMorning().getEnrollment()) / labOneCap)
                + ((labOne.getAfternoon().getEnrollment()) / labOneCap)) / 2;
        double labTwoUtil = (((labTwo.getMorning().getEnrollment()) / labTwoCap)
                + ((labTwo.getAfternoon().getEnrollment()) / labTwoCap)) / 2;
        double labThreeUtil = (((labThree.getMorning().getEnrollment()) / labThreeCap)
                + ((labThree.getAfternoon().getEnrollment()) / labThreeCap)) / 2;

        return (labOneUtil + labTwoUtil + labThreeUtil) / 3;
    }

    public int calculateAvailableSeats() {
        return 0;
    }

    public String listReservedLabs() {
        return "";
    }

    public String listAvailableLabs() {
        return "";
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        return "";
    }

    public String removeReservation(String location, String time) {
        return "";
    }

    public String modifyReservation(String location, String time, String name, int enrollment) {
        return "";
    }

    // Returns the String representation of this LabManager
    @Override
    public String toString() {
        return "LabManager{"
                + labOne.toString() + ", "
                + labTwo.toString() + ", "
                + labThree.toString() + '}';
    }
}
