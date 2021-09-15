package Homework04;
import java.util.Locale;
import java.util.Scanner;

/**
 * A program that determines the price of a custom-made toy.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Challenge
 *
 * @author Ben Winther
 * @version September 15, 2021
 */

public class ToySeller {

    private static String welcomeMessage = "Welcome to the Custom Toy Builder!\nOur store can custom-design " +
            "3 different types of toys.";
    private static String startMessage = "Which would you like to create? (Enter a number)\n" +
            "1. Superman figurine\n" +
            "2. Robotic cyclops\n" +
            "3. Cat-shaped lamp\n" +
            "4. EXIT";
    private static String endProgram = "Thanks for using the Custom Toy Builder!";

    private static String sizeQuestion = "What size toy would you like? (Enter S, M, or L)";
    private static String supermanQ1 = "Do you want Superman to talk? (Enter Y or N)";
    private static String supermanQ2 = "Do you want to add a cape? (Enter Y or N)";
    private static String roboticCyclopsQ1 = "Do you want the Robotic Cyclops to move? (Enter Y or N)";
    private static String roboticCyclopsQ2 = "What color eye do you want? (Enter 1, 2, or 3)\n" +
            "1. Red\n" +
            "2. Yellow\n" +
            "3. Blue";
    private static String catLampQ1 = "What color Cat-shaped Lamp do you want? (Enter 1, 2, 3, or 4)\n" +
            "1. Gold\n" +
            "2. Pink\n" +
            "3. Blue\n" +
            "4. No Color";
    private static String catLampQ2 = "Do you want the Cat-shaped Lamp to glow? (Enter Y or N)";

    private static String supermanCost = "Your Superman figurine costs";
    private static String roboticCyclopsCost = "Your Robotic Cyclops costs";
    private static String catLampCost = "Your Cat-shaped Lamp costs";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalPrice = 0;

        // Greets then asks for type of toy, using scanner to receive int
        System.out.println(welcomeMessage);
        System.out.println(startMessage);
        int toyType = scan.nextInt();
        scan.nextLine();

        // If wants toy, asks for size of toy and adds to price
        if(toyType > 0 && toyType < 4){
            System.out.println(sizeQuestion);
            char toySize = scan.nextLine().toUpperCase().charAt(0);
            if(toySize == 'S') totalPrice += 5;
            else if(toySize == 'M') totalPrice += 10;
            else totalPrice += 15;
        }

        /*
         * Since all further questions are case-sensitive to which
         * type of toy is wanted, the switch statement allows to
         * only ask the necessary questions for the "toyType".
         */
        switch (toyType) {
            case 1 -> {
                // Asks if they want it to speak
                System.out.println(supermanQ1);
                char talk = scan.nextLine().toUpperCase().charAt(0);
                if (talk == 'Y') totalPrice += 8;
                else totalPrice += 4;

                // Asks if they want it to have a cape
                System.out.println(supermanQ2);
                char cape = scan.nextLine().toUpperCase().charAt(0);
                if (cape == 'Y') totalPrice += 5;

                System.out.printf("%s $%d!\n", supermanCost, totalPrice);
            }
            case 2 -> {
                // Asks if they want it to move
                System.out.println(roboticCyclopsQ1);
                char move = scan.nextLine().toUpperCase().charAt(0);
                if (move == 'Y') totalPrice += 5;
                else totalPrice += 3;

                // Asks what color eye they want it to have
                System.out.println(roboticCyclopsQ2);
                int eyeColor = scan.nextInt();
                if (eyeColor == 1) totalPrice += 5;
                else if (eyeColor == 2) totalPrice += 6;
                else totalPrice += 7;

                System.out.printf("%s $%d!\n", roboticCyclopsCost, totalPrice);
            }
            case 3 -> {
                // Asks what color they want it to be
                System.out.println(catLampQ1);
                int color = scan.nextInt();
                scan.nextLine();
                if (color == 1) totalPrice += 10;
                else if (color == 4) totalPrice += 5;
                else totalPrice += 7;

                // Asks if they want it to glow only if they asked for color
                if(color != 4) {
                    System.out.println(catLampQ2);
                    char glow = scan.nextLine().toUpperCase().charAt(0);
                    if (glow == 'Y') totalPrice += 10;
                }

                System.out.printf("%s $%d!\n", catLampCost, totalPrice);
            }
            default -> System.out.println(endProgram);
        }
    }
}
