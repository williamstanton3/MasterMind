public class cardTester {
    // no class variables
    public static void main(String[] args) {
        Card c1 = new Card("Diamonds", "six");
        Card c2 = new Card("Clubs", "four");
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println(c1.isSameAs(c2));


    }
}
