package ExamMidterm1;

/**
 * Card Class
 *
 * A class representing an individual card with unique
 * rarity, name, brand, base price, and whether or not
 * its limited.
 *
 * @author Ben Winther
 *
 * @version 10/5/2021
 *
 */
public class Card {

    // The rarity of the card
    private String rarity;

    // The name of the card
    private String name;

    //The brand of the card
    private String brand;

    // The limited availability status of this card
    private boolean isLimited;

    // The base price of this card
    private double basePrice;

    // Constructs a newly allocated Card object and instantiates the fields to the specified parameters
    public Card(String rarity, String name, String brand, boolean isLimited, double basePrice) {
        this.rarity = rarity;
        this.name = name;
        this.brand = brand;
        this.isLimited = isLimited;
        this.basePrice = basePrice;
    }

    // Gets the Rarity of this card
    public String getRarity() {
        return rarity;
    }

    // Gets the Name of this card
    public String getName() {
        return name;
    }

    // Gets the Brand of this card
    public String getBrand() {
        return brand;
    }

    // Gets this card has limited availability
    public boolean getLimited() {
        return isLimited;
    }

    // Gets the Base Price of this card
    public double getBasePrice() {
        return basePrice;
    }

    // Sets the Rarity of this card
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    // Sets the Name of this card
    public void setName(String name) {
        this.name = name;
    }

    // Sets the Brand of this card
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Sets the limited availability status of this card
    public void setLimited(boolean limited) {
        isLimited = limited;
    }

    // Sets the Base Price of this card
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /*
     *Returns the modified price. Multiply the basePrice by the appropriate value for each rarity and return the result.
     */
    public double calculateModifiedPrice() {
        double modifiedPrice = basePrice;
        switch(rarity) {
            case "Common" -> {
                modifiedPrice = basePrice * 13;
            }
            case "Uncommon" -> {
                modifiedPrice = basePrice * 54;
            }
            case "Super" -> {
                modifiedPrice = basePrice * 133;
            }
            case "Rare" -> {
                modifiedPrice = basePrice * 267;
            }
            case "Legendary" -> {
                modifiedPrice = basePrice * 599;
            }
        }
        return modifiedPrice;
    }

    public String toString() {
        String price = String.format("%.2f", basePrice);
        return "Card<rarity=" + rarity + ", name=" + name
                + ", brand=" + brand + ", isLimited="
                + isLimited + ", basePrice=" + price;
    }
}