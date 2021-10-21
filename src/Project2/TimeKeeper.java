package Project2;

import java.util.Scanner;

public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";


    public static void main(String[] args) {

        // Initialize Scanner Object
        Scanner scan = new Scanner(System.in);

        // Welcome and initial Menu
        System.out.println(welcomePrompt);
        int initialize;
        do {
            System.out.println(initializeMenu);
            initialize = scan.nextInt();
            if (initialize != 1 && initialize != 2) {
                System.out.println(invalidInput);
            }
        } while(initialize != 1 && initialize != 2);
        scan.nextLine();

        // Doesn't continue if user chose to "Exit"
        if (initialize == 2) {
            System.out.println(exitMessage);
        } else{
            // If the user decides to initialize:
            // Establishes initial variables for the labs
            String labOneLocation = "";
            String labTwoLocation = "";
            String labThreeLocation = "";
            int labOneCapacity = 0;
            int labTwoCapacity = 0;
            int labThreeCapacity = 0;

            /*
             * Loops to each Lab and prompts the user to input the capacity
             * and location of said lab
             */
            for(int i = 1; i <= 3; i++) {
                System.out.println(enterLabCapacity + i + ":");
                switch(i) {
                    case 1 -> {
                        labOneCapacity = scan.nextInt();
                        scan.nextLine();
                    }
                    case 2 -> {
                        labTwoCapacity = scan.nextInt();
                        scan.nextLine();
                    }
                    case 3 -> {
                        labThreeCapacity = scan.nextInt();
                        scan.nextLine();
                    }
                }
                System.out.println(enterLabLocation + i + ":");
                switch(i) {
                    case 1 -> {
                        labOneLocation = scan.nextLine();
                    }
                    case 2 -> {
                        labTwoLocation = scan.nextLine();
                    }
                    case 3 -> {
                        labThreeLocation = scan.nextLine();
                    }
                }
            }

            // Constructs LabManager Object and the Labs that it will manage
            Lab labOne = new Lab(labOneCapacity, labOneLocation);
            Lab labTwo = new Lab(labTwoCapacity, labTwoLocation);
            Lab labThree = new Lab(labThreeCapacity, labThreeLocation);
            LabManager m = new LabManager(labOne, labTwo, labThree);

            // Repeats the Ongoing Menu until the user decides to Exit
            int ongoing;
            do {
                System.out.println(ongoingMenu);
                ongoing = scan.nextInt();
                scan.nextLine();
                /*
                 * If the user decides to exit, the program skips everything
                 * else and exits. If they input less than 0 or greater than
                 * 8 the program prints "Error" and the loop repeats. Else
                 * the number inputted determines the switch statement case
                 * the program will execute.
                 */
                if (ongoing == 8) {
                    System.out.println(exitMessage);
                } else if (ongoing < 1 || ongoing > 8) {
                    System.out.println(invalidInput);
                } else {
                    switch(ongoing) {
                        case 1 -> {
                            System.out.println(m.getLabOne().toString() + "\n"
                            + m.getLabTwo().toString() + "\n" + m.getLabThree().toString());
                        }
                        case 2 -> {
                            System.out.println(m.listAvailableLabs());
                        }
                        case 3 -> {
                            System.out.println(m.listReservedLabs());
                        }
                        case 4 -> {
                            System.out.println(labLocationPrompt);
                            String location = scan.nextLine();

                            System.out.println(reservationTimePrompt);
                            String time = scan.nextLine();

                            System.out.println(reservationNamePrompt);
                            String name = scan.nextLine();

                            System.out.println(reservationEnrollmentPrompt);
                            int enrollment = scan.nextInt();
                            scan.nextLine();

                            System.out.println(m.addReservation(location, time, name, enrollment));
                        }
                        case 5 -> {
                            System.out.println(labLocationPrompt);
                            String location = scan.nextLine();

                            System.out.println(reservationTimePrompt);
                            String time = scan.nextLine();

                            System.out.println(m.removeReservation(location,time));
                        }
                        case 6 -> {
                            System.out.println(labLocationPrompt);
                            String location = scan.nextLine();

                            System.out.println(reservationTimePrompt);
                            String time = scan.nextLine();

                            System.out.println(reservationNameUpdate);
                            String name = scan.nextLine();

                            System.out.println(reservationEnrollmentUpdate);
                            int enrollment = scan.nextInt();
                            scan.nextLine();

                            System.out.println(m.modifyReservation(location, time, name, enrollment));

                        }
                        case 7 -> {
                            int statistics;
                            do {
                                System.out.println(statisticsMenu);
                                statistics = scan.nextInt();
                                if (statistics == 4) {
                                    return;
                                } else if (statistics < 0 || statistics > 4) {
                                    System.out.println(invalidInput);
                                } else {
                                    switch(statistics) {
                                        case 1 -> {
                                            System.out.println(totalCapacity + m.calculateTotalCapacity());
                                        }
                                        case 2 -> {
                                            System.out.println(totalUtilization + m.calculateTotalUtilization());
                                        }
                                        case 3 -> {
                                            System.out.println(availableSeats + m.calculateAvailableSeats());
                                        }
                                    }
                                }
                            } while(statistics != 4);
                        }
                    }
                }
            } while(ongoing != 8);

        }
    }
}
