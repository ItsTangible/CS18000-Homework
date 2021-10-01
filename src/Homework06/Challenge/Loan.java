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
        monthlyPayment = amount * (rate / 12)  * (Math.pow((1 + rate / 12),duration)) / (Math.pow((1 + rate / 12), duration) - 1 );
        return monthlyPayment;
    }

    public double calculateTotalInterest(boolean output) {
        int paymentNumber = 1;
        double currentAmount = amount;
        double principle = 0;
        double interest = 0;
        double totalInterest = 0;
        while (paymentNumber <= duration) {
            interest = (currentAmount/12)*rate;
            principle = monthlyPayment - interest;
            currentAmount = currentAmount - principle;
            if (output) {
                amorTable(paymentNumber, principle, interest, currentAmount);
            }
            totalInterest += interest;
            paymentNumber++;
        }
        return Double.parseDouble(String.format("%.2f", totalInterest));
    }

    public void amorTable(int number, double principle, double interest, double remaining) {
        System.out.printf("Payment: %d", number);
        System.out.printf(" - Principle: %.2f", principle);
        System.out.printf(" - Interest: %.2f", interest);
        System.out.printf(" - Remaining: %.2f%n", remaining);
    }

    public String toString() {
        return "Amount: " + amount + " - Rate: " + rate + " - Duration: " + duration + " - Payment: " + String.format("%.2f", monthlyPayment);
    }

}
