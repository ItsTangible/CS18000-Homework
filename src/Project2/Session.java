package Project2;

public class Session {

    // The name of the Session
    private String name;

    // The number of attendees enrolled in this Session
    private int enrollment;

    /* Construct a newly allocated Session object and
     * instantiate the fields to their respective
     * parameters
     */
    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }

    /* Construct a newly allocated Session object and
     * instantiate the fields to the following:
     * name = "", enrollment = 0
     */
    public Session() {
        this.name = "";
        this.enrollment = 0;
    }

    // Returns the name of this Session
    public String getName() {
        return name;
    }

    // Returns enrollment of this Session
    public int getEnrollment() {
        return enrollment;
    }

    // Sets the name of this Session
    public void setName(String name) {
        this.name = name;
    }

    // Sets the enrollment of this Session
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    // Returns the String representation of this Session
    @Override
    public String toString() {
        return "Session{Name - " + name
                + ", Enrollment - " + enrollment
                + '}';
    }
}
