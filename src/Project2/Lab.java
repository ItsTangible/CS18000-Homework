package Project2;

public class Lab {

    // The morning session associated with this lab
    private Session morning;

    // The afternoon session associated with this lab
    private Session afternoon;

    // The room capacity of this lab
    private int capacity;

    // The location of this lab
    private String location;

    /* Construct a newly allocated Lab object and instantiate
     * the fields to the specified parameters
     */
    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }

    /* Construct a newly allocated Lab object and instantiate
     * the fields to the specified parameters. Instantiate the
     * two Session fields by calling the Session constructor
     * with no parameters
     */
    public Lab(int capacity, String location) {
        this.morning = new Session();
        this.afternoon = new Session();
        this.capacity = capacity;
        this.location = location;
    }

    // Returns the morning session of this Lab
    public Session getMorning() {
        return morning;
    }

    // Returns the afternoon session of this Lab
    public Session getAfternoon() {
        return afternoon;
    }

    // Returns the capacity of this Lab
    public int getCapacity() {
        return capacity;
    }

    // Returns the location of this Lab
    public String getLocation() {
        return location;
    }

    // Sets the morning session of this Lab
    public void setMorning(Session morning) {
        this.morning = morning;
    }

    // Sets the afternoon session of this Lab
    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    // Sets the capacity of this Lab
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Sets the location of this Lab
    public void setLocation(String location) {
        this.location = location;
    }

    /* Returns a String that documents the available sessions
     * for this lab
     */
    public String listAvailabilities() {
        String availability = "";
        if (this.morning.getEnrollment() == 0) {
            availability += "Morning: Available\n";
        }
        if (this.afternoon.getEnrollment() == 0) {
            availability += "Afternoon: Availability\n";
        }
        if (availability.isEmpty()) {
            availability = "No Availabilities";
        }
        return availability;
    }

    /* Returns a String that documents the reserved sessions
     * for this lab.
     */
    public String listReservations() {
        String reservation = "";
        if (this.morning.getEnrollment() > 0) {
            reservation += "Morning: Reserved\n";
        }
        if (this.afternoon.getEnrollment() > 0) {
            reservation += "Afternoon: Reserved\n";
        }
        if (reservation.isEmpty()) {
            reservation = "No Reservations";
        }
        return reservation;
    }

    // Returns the String representation of this Lab
    @Override
    public String toString() {
        String morningString;
        String afternoonString;

        if (morning.getEnrollment() == 0) morningString = "Available";
        else morningString = morning.toString();

        if (afternoon.getEnrollment() == 0) afternoonString = "Available";
        else afternoonString = afternoon.toString();

        return "Lab{Capacity - " + capacity + ", Location - "
                + location + "Morning: " + morningString
                + ", Afternoon: " + afternoonString + '}';
    }
}
