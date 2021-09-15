package Homework04;

import java.util.Scanner;

/**
 * A program that identifies a travel destination.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Walkthrough
 *
 * @author Purdue CS
 * @version August 23, 2021
 */

public class TravelAgent {
    public static void main(String[] args) {
        String destination = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a number between 1-4 to select a destination!");
        int num = scanner.nextInt();

        switch(num) {
            case 1 -> destination = "Great Pyramid of Giza, Egypt";
            case 2 -> destination = "Amazon Rainforest, Brazil";
            case 3 -> destination = "Eiffel Tower, France";
            case 4 -> destination = "Mt. Fuji, Japan";
            default -> destination = "That's not a valid number! Guess we're not travelling...";
        }

        if(num > 0 && num < 5) {
            System.out.printf("Your travel destination: %s!\n", destination);
        }
        else System.out.println(destination);

    }
}

