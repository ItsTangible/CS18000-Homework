package ExamMidterm1;

/**
 * Card Collection Class
 *
 * A class representing a card collection that can
 * hold multiple cards and keep track of all their
 * unique qualities.
 *
 * @author Ben Winther
 *
 * @version 10/5/2021
 *
 */
public class CardCollection {

    // Number of Common cards in collection
    private int numCommon;

    // Number of Uncommon cards in collection
    private int numUncommon;

    // Number of Super cards in collection
    private int numSuper;

    // Number of Rare cards in collection
    private int numRare;

    // Number of Legendary cards in collection
    private int numLegendary;

    // Car Collection constructor that initializes the quantity of each card
    public CardCollection(int numCommon, int numUncommon, int numSuper, int numRare, int numLegendary) {
        this.numCommon = numCommon;
        this.numUncommon = numUncommon;
        this.numSuper = numSuper;
        this.numRare = numRare;
        this.numLegendary = numLegendary;
    }

    // Gets amount of Common cards in collection
    public int getNumCommon() {
        return numCommon;
    }

    // Gets amount of Uncommon cards in collection
    public int getNumUncommon() {
        return numUncommon;
    }

    // Gets amount of Super cards in collection
    public int getNumSuper() {
        return numSuper;
    }

    // Gets amount of Rare cards in collection
    public int getNumRare() {
        return numRare;
    }

    // Gets amount of Legendary cards in collection
    public int getNumLegendary() {
        return numLegendary;
    }

    // Sets amount of Common cards in collection
    public void setNumCommon(int numCommon) {
        this.numCommon = numCommon;
    }

    // Sets amount of Uncommon cards in collection
    public void setNumUncommon(int numUncommon) {
        this.numUncommon = numUncommon;
    }

    // Sets amount of Super cards in collection
    public void setNumSuper(int numSuper) {
        this.numSuper = numSuper;
    }

    // Sets amount of Rare cards in collection
    public void setNumRare(int numRare) {
        this.numRare = numRare;
    }


    // Sets amount of Legendary cards in collection
    public void setNumLegendary(int numLegendary) {
        this.numLegendary = numLegendary;
    }

    /*
     * Given a rarity String, return the percentage of the total cards of
     * that rarity currently present in the collection.
     */
    public double calculatePercentageByRarity(String rarity) {
        double totalCards = numCommon + numUncommon + numSuper + numRare + numLegendary;
        double percentage;
        String formatHolder;
        switch(rarity) {
            case "Common" -> {
                percentage = numCommon / totalCards;
            }
            case "Uncommon" -> {
                percentage = numUncommon / totalCards;
            }
            case "Super" -> {
                percentage = numSuper / totalCards;
            }
            case "Rare" -> {
                percentage = numRare / totalCards;
            }
            case "Legendary" -> {
                percentage = numLegendary / totalCards;
            }
            default -> {
                return 0;
            }
        }
        return Double.parseDouble(String.format("%.2f", percentage));
    }

    // Returns the total cost of every card in the collection.
    public double calculateTotalCollectionValue() {
        return (numCommon * 13) + (numUncommon * 54) + (numSuper * 133) + (numRare * 267)
                + (numLegendary * 5);
    }

    // Returns the String representation of this CardCollection
    public String toString() {
        return "CardCollection<numCommon=" + numCommon + ", numUncommon=" + numUncommon
                + ", numSuper=" + numSuper + ", numRare=" + numRare + ", numLegendary="
                + numLegendary + ">";
    }
}