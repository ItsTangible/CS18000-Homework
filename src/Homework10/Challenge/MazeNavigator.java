package Homework10.Challenge;

public class MazeNavigator extends Thread {

    private static int currentRow = 4;

    private static int currentColumn = 4;

    private static int moveNumber = 0;

    private static boolean started;

    private int playerNumber;

    private String filename;

    private static char[][] maze;

    public MazeNavigator(int playerNumber, String filename) {
        this.started = true;
        this.playerNumber = playerNumber;
        this.filename = filename;
    }
}
