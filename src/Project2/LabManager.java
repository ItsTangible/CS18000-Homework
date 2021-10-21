package Project2;

import java.util.Locale;

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

    /* Returns the total number of available seats for all three labs.
     * If a session is not reserved, the available seats for that session are the lab
     * capacity. If a session is reserved, the available seats would be the lab capacity
     * minus the enrollment
     */
    public int calculateAvailableSeats() {
        int labOneCap = labOne.getCapacity();
        int labTwoCap = labTwo.getCapacity();
        int labThreeCap = labThree.getCapacity();

        int labOneSeats = labOneCap - (labOne.getMorning().getEnrollment()
                + labOne.getAfternoon().getEnrollment());
        int labTwoSeats = labTwoCap - (labTwo.getMorning().getEnrollment()
                + labTwo.getAfternoon().getEnrollment());
        int labThreeSeats = labThreeCap - (labThree.getMorning().getEnrollment()
                + labThree.getAfternoon().getEnrollment());

        return labOneSeats + labTwoSeats + labThreeSeats;
    }

    // List the reservations for each lab
    public String listReservedLabs() {
        return "Lab One\n" + labOne.listReservations()
                + "\nLab Two\n" + labTwo.listReservations()
                + "\nLab Three\n" + labThree.listReservations();
    }

    // List the availabilities for each lab
    public String listAvailableLabs() {
        return "Lab One\n" + labOne.listAvailabilities()
                + "\nLab Two\n" + labTwo.listAvailabilities()
                + "\nLab Three\n" + labThree.listAvailabilities();
    }

    /* Adds a reservation for the lab at the specified location and time. Returns a message
     * depending on the outcome of the operation
     */
    public String addReservation(String location, String time, String name, int enrollment) {
        time = time.toLowerCase();
        if (location.equals(labOne.getLocation())) {
            if (time.equals("morning") && labOne.getMorning().getName().equals("")) {
                if (enrollment <= labOne.getCapacity()) {
                    labOne.getMorning().setEnrollment(enrollment);
                    labOne.getMorning().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && labOne.getAfternoon().getName().equals("")) {
                if (enrollment <= labOne.getCapacity()) {
                    labOne.getAfternoon().setEnrollment(enrollment);
                    labOne.getAfternoon().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else if (location.equals(labTwo.getLocation())) {
            if (time.equals("morning") && labTwo.getMorning().getName().equals("")) {
                if (enrollment <= labTwo.getCapacity()) {
                    labTwo.getMorning().setEnrollment(enrollment);
                    labTwo.getMorning().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && labTwo.getAfternoon().getName().equals("")) {
                if (enrollment <= labTwo.getCapacity()) {
                    labTwo.getAfternoon().setEnrollment(enrollment);
                    labTwo.getAfternoon().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else if (location.equals(labThree.getLocation())) {
            if (time.equals("morning") && labThree.getMorning().getName().equals("")) {
                if (enrollment <= labThree.getCapacity()) {
                    labThree.getMorning().setEnrollment(enrollment);
                    labThree.getMorning().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && !labThree.getAfternoon().getName().equals("")) {
                if (enrollment <= labThree.getCapacity()) {
                    labThree.getAfternoon().setEnrollment(enrollment);
                    labThree.getAfternoon().setName(name);
                    return "Reservation added!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else return "Error. Invalid location";
    }

    public String removeReservation(String location, String time) {
        time = time.toLowerCase();
        if (location.equals(labOne.getLocation())) {
            if (time.equals("morning") && !labOne.getMorning().getName().equals("")) {
                labOne.getMorning().setName("");
                labOne.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon") && !labOne.getAfternoon().getName().equals("")) {
                labOne.getAfternoon().setName("");
                labOne.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else return "Error. Invalid time.";
        } else if (location.equals(labTwo.getLocation())) {
            if (time.equals("morning") && !labTwo.getMorning().getName().equals("")) {
                labTwo.getMorning().setName("");
                labTwo.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon") && !labTwo.getAfternoon().getName().equals("")) {
                labTwo.getAfternoon().setName("");
                labTwo.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else return "Error. Invalid time.";
        } else if (location.equals(labThree.getLocation())) {
            if (time.equals("morning") && !labThree.getMorning().getName().equals("")) {
                labThree.getMorning().setName("");
                labThree.getMorning().setEnrollment(0);
                return "Reservation removed!";
            } else if (time.equals("afternoon") && !labThree.getAfternoon().getName().equals("")) {
                labThree.getAfternoon().setName("");
                labThree.getAfternoon().setEnrollment(0);
                return "Reservation removed!";
            } else return "Error. Invalid time.";
        } else return "Error. Invalid location";
    }

    public String modifyReservation(String location, String time, String name, int enrollment) {
        time = time.toLowerCase();
        if (location.equals(labOne.getLocation())) {
            if (time.equals("morning") && !labOne.getMorning().getName().equals("")) {
                if (enrollment <= labOne.getCapacity()) {
                    labOne.getMorning().setEnrollment(enrollment);
                    labOne.getMorning().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && !labOne.getAfternoon().getName().equals("")) {
                if (enrollment <= labOne.getCapacity()) {
                    labOne.getAfternoon().setEnrollment(enrollment);
                    labOne.getAfternoon().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else if (location.equals(labTwo.getLocation())) {
            if (time.equals("morning") && !labTwo.getMorning().getName().equals("")) {
                if (enrollment <= labTwo.getCapacity()) {
                    labTwo.getMorning().setEnrollment(enrollment);
                    labTwo.getMorning().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && !labTwo.getAfternoon().getName().equals("")) {
                if (enrollment <= labTwo.getCapacity()) {
                    labTwo.getAfternoon().setEnrollment(enrollment);
                    labTwo.getAfternoon().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else if (location.equals(labThree.getLocation())) {
            if (time.equals("morning") && !labThree.getMorning().getName().equals("")) {
                if (enrollment <= labThree.getCapacity()) {
                    labThree.getMorning().setEnrollment(enrollment);
                    labThree.getMorning().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else if (time.equals("afternoon") && !labThree.getAfternoon().getName().equals("")) {
                if (enrollment <= labThree.getCapacity()) {
                    labThree.getAfternoon().setEnrollment(enrollment);
                    labThree.getAfternoon().setName(name);
                    return "Reservation modified!";
                } else return "Error. Capacity exceeded";
            } else return "Error. Invalid time.";
        } else return "Error. Invalid location";
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
