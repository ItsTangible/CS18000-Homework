package Homework09.Walkthrough;

public class OneDollar extends DollarBill {

    public OneDollar() {
        super(1, "George Washington");
    }

    @Override
    public boolean acceptedVending() {
        return true;
    }
}
