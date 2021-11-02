package Project3;

import java.io.*;
import java.util.Scanner;
/**
 * Play Game class
 *
 * A playable game of Battleship that reads two players positions from .txt
 * files, takes alternating input from each player for what position they
 * want to target, and announces the winner once one player has destroyed all
 * the other's ships by printing the Game Log to GameLog.txt
 *
 * @author Benjamin Winther
 * @version 10/31/2021
 */
public class PlayGame {

    // Messages displayed when playing the Battleship game
    private static final String WELCOME_MESSAGE = "Hello, Welcome to Battleship!";
    private static final String ENTER_LETTER_MESSAGE = " - Enter a row letter from A - J";
    private static final String ENTER_COLUMN_NUMBER_MESSAGE = " - Enter a column number from 1 - 14";
    private static final String VICTORY_MESSAGE = "Enemy fleet destroyed. Congratulations player ";

    // The 2d array representing player 1's ships positions
    private static char[][] playerOnePositions = new char[10][14]; // 10 rows, 14 columns

    // The 2d array representing player 2's ships positions
    private static char[][] playerTwoPositions = new char[10][14]; // 10 rows, 14 columns






    public static void main(String[] args) throws IOException {

        /*
         * Fills in the 2d arrays for representing the positions with all the values
         * of the ships of both players from the "ShipPositionsPlayerOne.txt" and
         * "ShipPositionsPlayerTwo.txt"file for easier reference to it
         */
        BufferedReader brp1 = new BufferedReader(new FileReader("src/Project3/ShipPositionsPlayerOne.txt"));
        BufferedReader brp2 = new BufferedReader(new FileReader("src/Project3/ShipPositionsPlayerTwo.txt"));

        // Loops to every row to extract the positions
        for (int i = 0; i < 10; i++) {
            // Reads the next line of each file
            String temp1 = brp1.readLine();
            String temp2 = brp2.readLine();

            // Loops to every char in the current line
            for (int j = 0; j < 14; j++) {
                // Sets the current index of each positions map
                // to the current char in the current line
                playerOnePositions[i][j] = temp1.charAt(j);
                playerTwoPositions[i][j] = temp2.charAt(j);
            }
        }
        brp1.close();
        brp2.close();

        // Establishes Board Pattern variables before the positions are altered
        // The pattern of player 1's board positions
        String playerOnePattern = boardPatternDeterminer(playerOnePositions);
        // The pattern of player 2's board positions
        String playerTwoPattern = boardPatternDeterminer(playerTwoPositions);


        // Begin playing the Game

        // Displays welcome message
        System.out.println(WELCOME_MESSAGE);

        // Imports scanner to intake responses from players
        Scanner scan = new Scanner(System.in);

        int numTurnsPlayerOne = 0;
        int numTurnsPlayerTwo = 0;
        int playerOneHits = 0;
        int playerTwoHits = 0;
        int winnerTurns = 0;
        int loserHits = 0;
        int winner = 0;
        boolean playerOneTurn = true;
        boolean gameOn = true;

        while (gameOn) {
            int row;
            int col;
            int currentPlayer;
            if (playerOneTurn) currentPlayer = 1;
            else currentPlayer = 2;

            // Prompts the player whose turn it is to input a row character
            System.out.println("Player " + currentPlayer + ENTER_LETTER_MESSAGE);
            row = letterToIndex(scan.nextLine().charAt(0));

            // Prompts the player whose turn it is to input a column int
            System.out.println("Player " + currentPlayer + ENTER_COLUMN_NUMBER_MESSAGE);
            col = scan.nextInt();
            col--;
            scan.nextLine();

            if (playerOneTurn) {
                playerOneTurn = false;
                numTurnsPlayerOne++;
                if (playerTwoPositions[row][col] == 'H') {
                    playerTwoPositions[row][col] = 'M';
                    playerOneHits++;
                    System.out.println("Value:H");
                } else System.out.println("Value:M");
            } else {
                playerOneTurn = true;
                numTurnsPlayerTwo++;
                if (playerOnePositions[row][col] == 'H') {
                    playerOnePositions[row][col] = 'M';
                    playerTwoHits++;
                    System.out.println("Value:H");
                } else System.out.println("Value:M");
            }


            if (playerOneHits >= 17) {
                winner = 1;
                winnerTurns = numTurnsPlayerOne;
                loserHits = playerTwoHits;
                gameOn = false;
            } else if (playerTwoHits >= 17) {
                winner = 2;
                winnerTurns = numTurnsPlayerTwo;
                loserHits = playerOneHits;
                gameOn = false;
            }
        }

        scan.close();

        // Prints victory message for the winner and constructs GameLog
        System.out.println(VICTORY_MESSAGE + winner + "!");
        GameLog battleshipGame = new GameLog(winner, loserHits,
                winnerTurns, playerOnePattern, playerTwoPattern);

        String gameLogString = battleshipGame.toString();

        File battleshipGameLog = new File("GameLog.txt");

        FileWriter fw = new FileWriter(battleshipGameLog);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(gameLogString, 0, gameLogString.length());

        bw.flush();
        bw.close();
        fw.close();
    }

    /*
     * Returns the integer value of the char index representation the player inputs
     * when attempting to destroy a ship. If the letter is not one that is on the
     * board, the method returns -1 to show it is not an index.
     */
    public static int letterToIndex(char letter) {
        switch (letter) {
            case 'A' -> {
                return 0;
            }
            case 'B' -> {
                return 1;
            }
            case 'C' -> {
                return 2;
            }
            case 'D' -> {
                return 3;
            }
            case 'E' -> {
                return 4;
            }
            case 'F' -> {
                return 5;
            }
            case 'G' -> {
                return 6;
            }
            case 'H' -> {
                return 7;
            }
            case 'I' -> {
                return 8;
            }
            case 'J' -> {
                return 9;
            }
            default -> {
                return -1;
            }
        }
    }


    /*
     * Returns the pattern of the board inputted as a parameter.
     * Possible patterns:
     *
     * If the majority of hits (9 or more) are found in the top 3 rows of the board,
     * the board pattern is "Top Heavy"
     *
     * If the majority of hits (9 or more) are found in the middle 4 rows of the board,
     * the board pattern is "Middle Heavy"
     *
     * If the majority of hits (9 or more) are found in the bottom 3 rows of the board,
     * the board pattern is "Bottom Heavy"
     *
     * If none of the three areas above contain 9 or more hits,
     * the board pattern is "Scattered"
     */
    public static String boardPatternDeterminer(char[][] boardPositions) {
        int inTop = 0;
        int inMid = 0;
        int inBot = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (boardPositions[i][j] == 'H') {
                    if (i < 3) {
                        inTop++;
                    } else if (i < 7) {
                        inMid++;
                    } else {
                        inBot++;
                    }
                }
            }
        }

        if (inTop >= 9) return "Top Heavy";
        else if (inMid >= 9) return "Middle Heavy";
        else if (inBot >= 9) return "Bottom Heavy";
        else return "Scattered";
    }
}