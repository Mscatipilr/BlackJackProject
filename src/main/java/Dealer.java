

public class Dealer extends Person {
    public Dealer() {
        super.setName("Dealer");
    }

    public void printFirstHand() {
        System.out.println("The dealer has...");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
        System.out.println("   ---");
    }
}
