package Homework06.Challenge;
/**
 * Loan Class
 *
 * A class that represents a loan. Holds the durations
 * the loan is taken out for, rate at which interest is
 * taken, amount the loan is and the monthly payment.
 *
 * @author Ben Winther, section number
 *
 * @version 10/1/2021
 *
 */
public class Loan {

    // Fields
    private int duration;
    private double rate;
    private double amount;
    private double monthlyPayment;

    // Constructor
    public Loan (int duration, double rate, double amount) {
        this.duration = duration;
        this.rate = rate;
        this.amount = amount;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    // Getters
    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Methods
    public double calculateMonthlyPayment() {
        monthlyPayment = twoDecimals(amount * (rate / 12)  * (Math.pow((1 + rate / 12),duration)) / (Math.pow((1 + rate / 12), duration) - 1 ));
        return twoDecimals(monthlyPayment);
    }

    public double calculateTotalInterest(boolean output) {
        int paymentNumber = 1;
        double currentAmount = amount;
        double principle = 0;
        double interest = 0;
        double totalInterest = 0;
        while (paymentNumber <= duration) {
            interest = twoDecimals((currentAmount/12)*rate);
            principle = twoDecimals(monthlyPayment - interest);
            currentAmount = twoDecimals(currentAmount - principle);
            if (output) {
                amorTable(paymentNumber, principle, interest, currentAmount);
            }
            totalInterest += interest;
            paymentNumber++;
        }
        return totalInterest;
    }

    public void amorTable(int number, double principle, double interest, double remaining) {
        System.out.print("Payment: " + number);
        System.out.print(" - Principle: " + principle);
        System.out.print(" - Interest: " + interest);
        System.out.print(" - Remaining: " + remaining + "\n");
    }

    public double twoDecimals(double input) {
        double hold = Math.round(input*100.00);
        return hold/100.00;
    }

    public String toString() {
        return "Amount: " + amount + " - Rate: " + rate + " - Duration: " + duration + " - Payment: " + monthlyPayment;
    }

}
