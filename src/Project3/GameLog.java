package Project3;
/**
 * Game Log Class
 *
 * Creates a Log of a Game with a overridden toString
 *
 * @author Benjamin Winther
 * @version 10/31/2021
 */
public class GameLog {

    // The player number that won the game (1 for player 1 or 2 for player 2)
    private int winningPlayer;

    /*
     * The number of times the losing player hit a location on one of the other
     * player's ships.\
     */
    private int losingPlayerHits;

    /*
     * The number of turns (guesses at coordinates) that it took the winning player
     * to find all of the opponent's ships
     */
    private int numTurns;

    /*
     * The board pattern for player one's board ("Top Heavy", "Middle Heavy", "Bottom
     * Heavy", or "Scattered")
     */
    private String boardPatternOne;

    /*
     * The board pattern for player two's board ("Top Heavy", "Middle Heavy", "Bottom
     * Heavy", or "Scattered")
     */
    private String boardPatternTwo;

    /*
     * Construct a newly allocated GameLog object and instantiate the fields to their
     * respective parameters
     */
    public GameLog(int winningPlayer, int losingPlayerHits, int numTurns,
                   String boardPatternOne, String boardPatternTwo) {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }

    // Returns the String representation of this Session.
    @Override
    public String toString() {
        String hitRatio = "";
        if (winningPlayer == 1) hitRatio = "17 - " + losingPlayerHits;
        else hitRatio = losingPlayerHits + " - 17";
        return "Battleship Game Log:\n" +
                "Winning Player: Player " + winningPlayer + "\n" +
                "Hits: " + hitRatio + "\n" +
                "Number of Turns To Win: " + numTurns + "\n" +
                "Player 1 Board Pattern: " + boardPatternOne + "\n" +
                "Player 2 Board Pattern: " + boardPatternTwo;
    }
}