package Homework05;

import java.util.Scanner;

/**
 * Pattern Matcher
 *
 * A game where a user inputs a number and must guess
 * the next numbers in a pattern that is generated
 * depending on their chosen difficulty level
 *
 * @author Ben Winther, L14
 *
 * @version 9/26/2021
 *
 */

public class PatternMatcher {

    public static void main(String[] args) {

        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";

        Scanner scan = new Scanner(System.in);
        /* Set a boolean controlling if the player would
         * like to play again to control the game while
         * loop. Made the loop a do-while so that the
         * game would at least play once no matter what.
         */
        boolean playAgain = false;

        do {

            playAgain = false;

            /* Asks the player what level difficulty they
             * would like to play repeatedly until they
             * enter a valid difficulty. They must input
             * either: 1, 2, or 3
             */
            int levelInput;
            do {
                System.out.println(chooseLevel);
                levelInput = scan.nextInt();

            } while(levelInput <= 0 || levelInput >= 4);

            // Sets the first number in the sequence
            System.out.println(startNumber);
            int num1Input = scan.nextInt();

            /* The "ints" before the switch statement are
             * the different positions in the pattern since
             * we haven't learned arrays I didn't want to
             * get ahead of myself.
             *
             * Switch statement sets all the numbers
             * according to which level was chosen
             *
             * case 1: adds 2 each consecutive num
             *
             * case 2: multiplies by 4 each consequtive num
             *
             * case 3: multiplies each consequtive num by
             * itself then adds 1.
             */
            int num1 = num1Input;
            int num2;
            int num3;
            int num4;
            int num5;
            int num6;
            int num7;
            switch (levelInput) {
                case 1 -> {
                    num2 = num1+2;
                    num3 = num2+2;
                    num4 = num3+2;
                    num5 = num4+2;
                    num6 = num5+2;
                    num7 = num6+2;
                }
                case 2 -> {
                    num2 = num1*4;
                    num3 = num2*4;
                    num4 = num3*4;
                    num5 = num4*4;
                    num6 = num5*4;
                    num7 = num6*4;
                }
                case 3 -> {
                    num1 = ((num1)*(num1))+1;
                    num2 = ((num1Input+1)*(num1Input+1))+1;
                    num3 = ((num1Input+2)*(num1Input+2))+1;
                    num4 = ((num1Input+3)*(num1Input+3))+1;
                    num5 = ((num1Input+4)*(num1Input+4))+1;
                    num6 = ((num1Input+5)*(num1Input+5))+1;
                    num7 = ((num1Input+6)*(num1Input+6))+1;
                }
                default -> {
                    num2 = 0;
                    num3 = 0;
                    num4 = 0;
                    num5 = 0;
                    num6 = 0;
                    num7 = 0;
                    System.out.print("somethings wrong");
                }
            }

            /* Asks player to guess next 3 nums of pattern
             * Sets all guesses to ints
             */
            String firstFour = num1 + " " + num2 + " "
                    + num3 + " " + num4;
            System.out.print(nextThree + "\n" + firstFour + "\n");
            int guessNum5 = scan.nextInt();
            int guessNum6 = scan.nextInt();
            int guessNum7 = scan.nextInt();
            scan.nextLine();

            // Evaluates if the guesses are correct
            boolean correct = true;
            if (guessNum5 != num5) correct = false;
            if (guessNum6 != num6) correct = false;
            if (guessNum7 != num7) correct = false;

            if (correct) System.out.println(congratulations);
            else System.out.println(sorry);

            /* Asks if the player would like to play
             * again and they must input either: "y"
             * or "Y" to do so.
             */
            System.out.println(again);
            String yesOrNo = scan.nextLine().trim().toUpperCase();
            if (yesOrNo == null || yesOrNo.equals("") || yesOrNo.length() > 1) {
                playAgain = false;
                System.out.println(ending);
                break;
            } else if (yesOrNo.equals("Y"))
                playAgain = true;
            else {
                playAgain = false;
                System.out.println(ending);
                break;
            }
        } while(playAgain);
    }
}

