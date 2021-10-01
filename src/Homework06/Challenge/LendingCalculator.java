package Homework06.Challenge;

import java.util.Scanner;
/**
 * Lending Calculator
 *
 * A program that allows you to control and manage a loan to
 *
 * @author your name, section number
 *
 * @version date of completion
 *
 */

public class LendingCalculator {

    private static String welcomeMessage = "Welcome to the Lending Calculator!";
    private static String menu = "Menu";
    private static String initialMenu = "0. Quit\n1. Add a loan";
    private static String ongoingMenu = "0. Quit\n1. Modify Loan\n2. Calculate Total Interest";
    private static String exitMessage = "Thank you!";
    private static String durationMessage = "Enter the duration:";
    private static String rateMessage = "Enter the rate:";
    private static String amountMessage = "Enter the amount:";
    private static String amortizationPrompt = "Would you like to print the amortization schedule?";
    private static String amortizationMenu = "1. Yes\n2. No";
    private static String totalInterestMessage = "Total Interest: ";
    private static String errorMessage = "Error! Invalid input.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int duration = 0;
        double rate = 0;
        double amount = 0;
        boolean ongoing = true;

        System.out.println(welcomeMessage);
        System.out.println(menu);
        System.out.println(initialMenu);
        int initialMenuAnswer = scan.nextInt();

        if (initialMenuAnswer == 1) {
            System.out.println(durationMessage);
            duration = scan.nextInt();
            scan.nextLine();

            System.out.println(rateMessage);
            rate = scan.nextDouble();
            scan.nextLine();

            System.out.println(amountMessage);
            amount = scan.nextDouble();
            scan.nextLine();

            Loan loan = new Loan(duration, rate, amount);
            System.out.println(loan.toString());

            do {
                System.out.println(ongoingMenu);
                int ongoingMenuAns = scan.nextInt();
                switch(ongoingMenuAns) {
                    case 0 -> {
                        ongoing = false;
                    }
                    case 1 -> {
                        System.out.println(durationMessage);
                        duration = scan.nextInt();
                        scan.nextLine();
                        loan.setDuration(duration);

                        System.out.println(rateMessage);
                        rate = scan.nextDouble();
                        scan.nextLine();
                        loan.setRate(rate);

                        System.out.println(amountMessage);
                        amount = scan.nextDouble();
                        scan.nextLine();
                        loan.setAmount(amount);

                        loan.calculateMonthlyPayment();

                        System.out.println(loan.toString());
                    }
                    case 2 -> {
                        System.out.println(amortizationPrompt);
                        System.out.println(amortizationMenu);
                        int amortInput = scan.nextInt();
                        if (amortInput == 1) {
                            System.out.println("Total Interest: " + loan.calculateTotalInterest(true));
                        }
                        else {
                            System.out.println("Total Interest: " + loan.calculateTotalInterest(false));
                        }
                    }
                    default -> {
                        System.out.println(errorMessage);
                    }
                }

            } while(ongoing);
        }
        System.out.println(exitMessage);
    }
}
