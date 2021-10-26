package Project1;

import java.util.Scanner;
/**
 * A simple BaseballScores class
 *
 * @author Purdue CS
 * @version 08/23/2021
 */
public class BaseballScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Team One Name:");
        String teamOne = scanner.nextLine();
        System.out.println("Enter Team Two Name:");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter Inning Scores:");
        String scores = scanner.nextLine();


        scanner.close();

        // The scores for each inning are calculated and stored in the variables below.
        int currentScoreIndex = 0;
        int teamOneInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int teamOneInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        /*
         * Establishes all the necessary variables to keep track of
         * each teams' score, inning log, and perfect innings
         */
        int teamOneScore = teamOneInningOne + teamOneInningTwo + teamOneInningThree + teamOneInningFour
                + teamOneInningFive + teamOneInningSix + teamOneInningSeven + teamOneInningEight + teamOneInningNine;
        int teamTwoScore = teamTwoInningOne + teamTwoInningTwo + teamTwoInningThree + teamTwoInningFour
                + teamTwoInningFive + teamTwoInningSix + teamTwoInningSeven + teamTwoInningEight + teamTwoInningNine;

        // Determines the winner assuming there is no ties
        String winner;
        int winnerScore;
        int loserScore;
        if (teamOneScore > teamTwoScore) {
            winner = teamOne;
            winnerScore = teamOneScore;
            loserScore = teamTwoScore;
        } else {
            winner = teamTwo;
            winnerScore = teamTwoScore;
            loserScore = teamOneScore;
        }

        int teamOnePerfect = 0;
        String teamOneLog = "";

        int teamTwoPerfect = 0;
        String teamTwoLog = "";


        /*
         * Using if statements, goes an inning at a time determining
         * what to add to the log and whether to add to the perfect innings
         */

        // First Inning
        if (teamOneInningOne > teamTwoInningOne) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningOne == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningOne > teamOneInningOne) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningOne == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Second Inning
        if (teamOneInningTwo > teamTwoInningTwo) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningTwo == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningTwo > teamOneInningTwo) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningTwo == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Third Inning
        if (teamOneInningThree > teamTwoInningThree) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningThree == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningThree > teamOneInningThree) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningThree == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Fourth Inning
        if (teamOneInningFour > teamTwoInningFour) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningFour == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningFour > teamOneInningFour) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningFour == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Fifth Inning
        if (teamOneInningFive > teamTwoInningFive) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningFive == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningFive > teamOneInningFive) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningFive == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Sixth Inning
        if (teamOneInningSix > teamTwoInningSix) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningSix == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningSix > teamOneInningSix) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningSix == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Seventh Inning
        if (teamOneInningSeven > teamTwoInningSeven) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningSeven == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningSeven > teamOneInningSeven) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningSeven == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Eighth Inning
        if (teamOneInningEight > teamTwoInningEight) {
            teamOneLog += "W-";
            teamTwoLog += "L-";
            if (teamTwoInningEight == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningEight > teamOneInningEight) {
            teamTwoLog += "W-";
            teamOneLog += "L-";
            if (teamOneInningEight == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T-";
            teamTwoLog += "T-";
        }

        // Ninth Inning
        if (teamOneInningNine > teamTwoInningNine) {
            teamOneLog += "W";
            teamTwoLog += "L";
            if (teamTwoInningNine == 0) {
                teamOnePerfect += 1;
            }
        } else if (teamTwoInningNine > teamOneInningNine) {
            teamTwoLog += "W";
            teamOneLog += "L";
            if (teamOneInningNine == 0) {
                teamTwoPerfect += 1;
            }
        } else {
            teamOneLog += "T";
            teamTwoLog += "T";
        }

        /*
         * Prints out the Scores of each team at the end of the game,
         * the inning log of the game, and the amount of perfect
         * innings each team had by the end of the game.
         */
        int differential = winnerScore - loserScore;
        System.out.println("The winner is: " + winner + ", with a score differential of " + differential);
        System.out.println(teamOne + " scored " + teamOneScore + " points.");
        System.out.println(teamTwo + " scored " + teamTwoScore + " points.");
        System.out.println(teamOne + " Game Log: " + teamOneLog);
        System.out.println(teamTwo + " Game Log: " + teamTwoLog);
        System.out.println(teamOne + " Perfect Innings: " + teamOnePerfect);
        System.out.println(teamTwo + " Perfect Innings: " + teamTwoPerfect);

    }
}
