package Homework10.Challenge;

import java.io.*;
/**
 * Maze Navigator Class
 *
 * Navigates through a Maze of char[][] using player input from
 * different playerMoves.txt files
 *
 * @author Benjamin Winther
 * @version 11/2/2021
 */
public class MazeNavigator extends Thread {

    private static int currentRow = 4;

    private static int currentColumn = 4;

    private static int moveNumber = 0;

    private static boolean started;

    private int playerNumber;

    private String filename;

    private static char[][] maze = new char[10][10];

    public MazeNavigator(int playerNumber, String filename) {
        this.started = true;
        this.playerNumber = playerNumber;
        this.filename = filename;
    }

    static {
        // Sets up Maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = ' ';
                if (i == currentRow && j == currentColumn) {
                    maze[i][j] = 'X';
                }
            }
        }
        // Prints Welcome Message and Initial Maze
        System.out.println("Welcome! Initial Maze:");
        printMaze(maze);
    }

    public void run() {
        // Reads next move of player
        int playerMove = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            playerMove = (Integer) bf.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String moveDirection = makeMove(playerMove);

        System.out.println("Move number: " + moveNumber);
        System.out.println("Player " + playerNumber);
        System.out.println("Move: " + moveDirection);
        printMaze(maze);

    }

    public static void main(String[] args) {
        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1,
                    "src/Homework10/Challenge/PlayerOneMoves.txt"),
                new MazeNavigator(2, "src/Homework10/Challenge/PlayerTwoMoves.txt")};

            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start();
            }
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    public static void printMaze(char[][] maze) {
        String mazeString = "";
        for (int i = 0; i < maze.length; i++) {
            mazeString += "[";
            for (int j = 0; j < maze[i].length; j++) {
                mazeString += maze[i][j];
                if (j < maze[i].length - 1) mazeString += ",";
            }
            mazeString += "]\n";
        }
        System.out.println(mazeString);
    }

    public synchronized String makeMove(int move) {
        switch (move) {
            case 1 -> {
                currentColumn--;
                return "Left";
            }
            case 2 -> {
                currentColumn++;
                return "Right";
            }
            case 3 -> {
                currentRow++;
                return "Up";
            }
            case 4 -> {
                currentRow--;
                return "down";
            }
        }
        return "None";
    }
}
