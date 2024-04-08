import java.util.ArrayList;
import java.util.Scanner;

public class GoFish {
    public static void main(String[] args) {
        // creates deck of cards and deals 7
        Deck cardDeck = new Deck();
        cardDeck.shuffle();
        ArrayList<Card> cardList;
        cardList = cardDeck.dealHand(7);
        System.out.println(cardList);

        // creates an array of suits in the cards that have been dealt

        Scanner scr = new Scanner(System.in);
        boolean isTrue = true;

        System.out.print("Guess a card: ");
        String guess = scr.next();

        for (int i = 0; i < cardList.size(); i++) {
            if (guess.equals(cardList.get(i).getValue())) {
                System.out.println("Yes, I have that " + guess);
                isTrue = true;
                break;
            }
            else {
                isTrue = false;
            }
        }
        if (!isTrue) {
            System.out.println("Go fish!");
        }


    }
}
