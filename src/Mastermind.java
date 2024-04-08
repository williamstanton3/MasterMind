import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    private ArrayList<Character> secret;
    private static ArrayList<Character> colors = new ArrayList<>(List.of('R', 'Y', 'B', 'G', 'P'));

    /**
     * creates a random arrayList of 4 colors
     */
    public Mastermind() {
        secret = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int index = rand.nextInt(colors.size());
            secret.add(colors.get(index));
        }
        System.out.println(secret);
    }

    /**
     * Game loop that asks user for a guess until they guess the secret correctly
     */
    public void gameLoop() {
        Scanner scnr = new Scanner(System.in);

        int guesses = 0;
        boolean game = true;
        ArrayList<Character> guess;

        while (game) {
            guess = new ArrayList<>();
            System.out.println("Enter new guess:");
            String guess1 = scnr.next();
            for (int i = 0; i < guess1.length(); i++) {
                guess.add(guess1.charAt(i));
            }
            if (numAllRight(guess) == secret.size()) {
                game = false;
            }
            System.out.println(numAllRight(guess) + " pegs of correct color and position");
            System.out.println(numHalfRight(guess) + " pegs of correct color but wrong position");
            guesses++;
        }
        System.out.println("Congrats! You've won!");
        System.out.println("It took you " + guesses + " guesses to crack the code!");

    }

    /**
     * counts the number of colors the user guessed correctly and in the correct spot
     *
     * @param guess an ArrayList containing the user's guesses
     * @return the number of fully correct colors
     */
    public int numAllRight(ArrayList<Character> guess) {
        int allRight = 0;
        for (int i = 0; i < colors.size() - 1; i++) {
            char guesser = guess.get(i);
            if (guesser == secret.get(i)) {
                allRight += 1;
            }
        }
        return allRight;
    }

    /**
     * removes the fully correct colors and counts the number of colors the user guessed correctly but in the wrong spot
     *
     * @param guess an ArrayList containing the user's guesses
     * @return the number of half correct colors
     */
    public int numHalfRight(ArrayList<Character> guess) {
        int count = 0;
        ArrayList<Character> guessCopy = new ArrayList<>(guess);
        ArrayList<Character> secretCopy = new ArrayList<>(secret);
        for (int i = guess.size() - 1; i >= 0; i--) {
            if (guess.get(i).equals(secret.get(i))) {
                guessCopy.remove(i);
                secretCopy.remove(i);
            }
        }
        System.out.println(guessCopy + " - guess copy");
        System.out.println(secretCopy + " - secret copy");
        for (int i = 0; i < guessCopy.size(); i++) {
            for (int j = 0; j < secretCopy.size(); j++) {
                if (guessCopy.get(i).equals(secretCopy.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

}