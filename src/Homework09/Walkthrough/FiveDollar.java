package Homework09.Walkthrough;

public class FiveDollar extends DollarBill {

    public FiveDollar() {
        super(5, "Abraham Lincoln");
    }

    @Override
    public boolean acceptedVending() {
        return true;
    }
}
