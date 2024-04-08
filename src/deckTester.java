import java.util.ArrayList;

public class deckTester {
    /**
     * checks to see if the hand is a flush
     * @param hand is the hand of cards
     * @return true if hand is a flush
     */
    public static boolean isFlush(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size()-1; i++) {
            String suit1 = hand.get(i).getSuit();
            String suit2 = hand.get(i).getSuit();
            if (!suit1.equals(suit2)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        double flushCount = 0;

        Deck d1 = new Deck();
        System.out.println(d1);
        d1.shuffle();
        System.out.println(d1);

        for (int i = 0; i < 100000; i++) {
            d1.shuffle();
            ArrayList<Card> cardA = new ArrayList<>();
            cardA = d1.dealHand(5);
        }

        double prob = ((flushCount)/100000.0) * 100;
        System.out.printf("The probability of a flush is %.5f", prob);
    }
}
