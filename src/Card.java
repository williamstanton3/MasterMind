public class Card {
    private final String suit;
    private final String value;
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        return value;
    }

    /**
     * This method is the default constructor
     * it initializes both suit and value as empty strings
     */
    public Card() {
        this.suit = "";
        this.value = "";
    }
    /**
     * This method is the parameterized constructor
     * it initializes both suit and value to their respective user input
     */
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * @return the card as a string
     */
    public String toString() {
        return (value + " of " + suit);
    }

    /**
     * checks to see if two cards have equal suits and values
     * @param other is the second card
     * @return true if the cards are equal
     */
    public boolean isSameAs(Card other) {
        return (this.suit.equals(other.suit)) && (this.value.equals(other.value));
    }

}
