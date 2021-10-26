package Project3;
/**
 * Game Log Class
 *
 *
 *
 * @author Purdue CS
 * @version 08/23/2021
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
                   String boardPatternOne, String boardPatternTwo){
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }

    @Override
    public String toString() {
        return "Battleship Game Log:\n" +
                "Winning Player: " + winningPlayer + "\n" +
                "Hits: " + losingPlayerHits + "\n" +
                "Number of Turns To Win: " + numTurns + "\n" +
                "Player 1 Board Pattern: " + boardPatternOne + "\n" +
                "Player 2 Board Pattern: " + boardPatternTwo;
    }
}
