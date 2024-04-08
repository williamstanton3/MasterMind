import java.util.ArrayList;
import java.util.Random;

/**
 * creates the deck of cards
 */
public class Deck {
    /**
     * lists different suits
     */
    public static String[] suits = {"hearts", "diamonds", "clubs", "spades"};
    /**
     * lists different face values
     */
    public static String[] faceValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    /**
     * creates an array of cards
     */
    ArrayList<Card> cardDeck = new ArrayList<>();
    /**
     * swaps the suit and value of two cards
     * @param card1 is the first card being swapped
     * @param card2 is the second card being swapped
     */
    public void swap(int card1, int card2) {
        Card temp = cardDeck.get(card1);
        cardDeck.set(card1, cardDeck.get(card2));
        cardDeck.set(card2, temp);
    }
    /**
     * shuffles the deck of cards
     * initializes nextToDeal back to zero
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            swap(i,rand.nextInt(52));
        }
    }
    /**
     * default constructor for the deck
     */
    public Deck() {
        for (int i = 0; i < 52; i++) {
            cardDeck.add(new Card(suits[i/13], faceValues[i%13]));
        }
    }
    /**
     * converts the deck to a string of cards
     * @return the deck as a giant string of cards
     */
    public String toString() {
        String theDeck = "";
        for (int i = 0; i < 52; i++) {
            theDeck = theDeck + " " + cardDeck.get(i);
        }
        return theDeck;
    }
    public Card getAt (int num) {
        return cardDeck.get(num);
    }
    /**
     * deals a Card
     * @return the Card at the index nextToDeal
     */
    public Card dealCard() {
        Card theCard = cardDeck.get(0);
        cardDeck.remove(0);
        if (cardDeck.isEmpty()) {
            return null;
        }
        else {
            return theCard;
        }
    }
    /**
     * deals a Hand of cards
     * @param handSize is the number of cards in the hand
     * @return the hand of cards
     */
    public ArrayList<Card> dealHand(int handSize) {
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            Card cardB = dealCard();
            cardList.add(cardB);
        }
        return cardList;
    }
    public int cardsLeft() {
        return cardDeck.size();
    }
}
