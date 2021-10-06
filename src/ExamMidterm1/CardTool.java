package ExamMidterm1;

import java.util.Scanner;
/**
 * Card Tool Class
 *
 * A class that allows you to add cards to a purchase
 * specifying their rarity and name. It collects the
 * total price and when you are done adding prints
 * all the names and the total price to you.
 *
 * @author Ben Winther
 *
 * @version 10/5/2021
 *
 */
public class CardTool {
    
        private static String welcomeMessage = "Welcome to the Trading Card Tool!"; 
        private static String initialPrompt = "Would you like to add a card?"; 
        private static String menu = "(1) Common\n" + 
                                     "(2) Uncommon\n" + 
                                     "(3) Super\n" + 
                                     "(4) Rare\n" + 
                                     "(5) Legendary\n" +
                                     "(6) Exit"; 
        private static String rarityPrompt = "Enter the card rarity you would like to place in the deck."; 
        private static String cardNamePromptOne = "What is the name of the ";
        private static String cardNamePromptTwo = " trading card?";
        private static String anotherPrompt = "Would you like to add another card?";
        private static String totalCostMessage = "The total cost for all the cards you collected today is ";
        private static String receiptMessage = "After collecting the cards, here's your receipt: ";
        private static String collectionMessageOne = "You collected ";
        private static String collectionMessageCommon = " Common card(s)."; 
        private static String collectionMessageUncommon = " Uncommon card(s)."; 
        private static String collectionMessageSuper = " Super card(s)."; 
        private static String collectionnMessageRare = " Rare card(s)."; 
        private static String collectionMessageLegendary = " Legendary card(s)."; 
        private static String exitMessage = "Thank you for using the Trading Card Tool!"; 
        private static String invalidInputMessage = "You chose an invalid menu choice, try again!";

        public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);

                /*
                 * The user is prompted if they would like to add a card.
                 * If they don't the program never enters the if statement.
                 */
                System.out.println(welcomeMessage);
                System.out.println(initialPrompt);
                String addCard = scan.nextLine();

                if (addCard.equals("yes") || addCard.equals("Yes")) {
                        boolean exit = false;

                        int commonCards = 0;
                        int uncommonCards = 0;
                        int superCards = 0;
                        int rareCards = 0;
                        int legendaryCards = 0;
                        int totalPrice = 0;
                        String reportCode = "";

                        boolean addAnotherCard = false;
                        do {
                                /*
                                 * In this Area of the code the user is choosing the
                                 * Rarity of the card they want to add. If their
                                 * input is not valid, the program lets them know and
                                 * asks them to input a valid input.
                                 */
                                boolean valid = true;
                                String rarityName = "";
                                do {
                                        System.out.println(menu);
                                        System.out.println(rarityPrompt);
                                        int rarity = scan.nextInt();
                                        scan.nextLine();

                                        switch (rarity) {
                                                case 1 -> {
                                                        rarityName = "Common";
                                                        commonCards++;
                                                        totalPrice += 13;
                                                        reportCode += "C:";
                                                        valid = true;
                                                }
                                                case 2 -> {
                                                        rarityName = "Uncommon";
                                                        uncommonCards++;
                                                        totalPrice += 54;
                                                        reportCode += "U:";
                                                        valid = true;
                                                }
                                                case 3 -> {
                                                        rarityName = "Super";
                                                        superCards++;
                                                        totalPrice += 133;
                                                        reportCode += "S:";
                                                        valid = true;
                                                }
                                                case 4 -> {
                                                        rarityName = "Rare";
                                                        rareCards++;
                                                        totalPrice += 267;
                                                        reportCode += "R:";
                                                        valid = true;
                                                }
                                                case 5 -> {
                                                        rarityName = "Legendary";
                                                        legendaryCards++;
                                                        totalPrice += 599;
                                                        reportCode += "L:";
                                                        valid = true;
                                                }
                                                case 6 -> {
                                                        rarityName = "Exit";
                                                        exit = true;
                                                        valid = true;
                                                }
                                                default -> {
                                                        System.out.println(invalidInputMessage);
                                                        valid = false;
                                                }
                                        }
                                } while(!valid);
                                if (!exit) {
                                        System.out.println(cardNamePromptOne + rarityName + cardNamePromptTwo);
                                        String cardName = scan.nextLine();
                                        reportCode += cardName;

                                        System.out.println(anotherPrompt);
                                        String anotherCard = scan.nextLine();
                                        if (anotherCard.equals("Yes") || anotherCard.equals("yes")) {
                                                addAnotherCard = true;
                                                reportCode += ";";
                                        }
                                        else addAnotherCard = false;
                                }
                        } while(addAnotherCard);

                        if (!exit) {
                                // Prints Total Cost
                                System.out.println(totalCostMessage + totalPrice);

                                // Prints a String of all the cards bought
                                System.out.println(receiptMessage + reportCode);

                                // Lists out the total of each card type purchased
                                System.out.println(collectionMessageOne + commonCards + collectionMessageCommon);

                                System.out.println(collectionMessageOne + uncommonCards + collectionMessageUncommon);

                                System.out.println(collectionMessageOne + superCards + collectionMessageSuper);

                                System.out.println(collectionMessageOne + rareCards + collectionnMessageRare);

                                System.out.println(collectionMessageOne + legendaryCards + collectionMessageLegendary);
                        }
                }

                System.out.println(exitMessage);

        }
}
