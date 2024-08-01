import java.io.PrintStream;

// Abstract class representing a person in the game
public abstract class Person {
    private Hand hand = new Hand();
    private String name = "";

    // Constructor
    public Person() {
    }

    // Get the person's hand
    public Hand getHand() {
        return this.hand;
    }

    // Set the person's hand
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    // Get the person's name
    public String getName() {
        return this.name;
    }

    // Set the person's name
    public void setName(String name) {
        this.name = name;
    }

    // Print the person's hand
    public void printHand() {
        System.out.println(this.name + "'s hand looks like this...");
        PrintStream message = System.out;
        String valMes = String.valueOf(this.hand);
        message.println(valMes + " Valued at: " + this.hand.calculatedValue());
        System.out.println("   ---");
    }

    // Perform a hit action: take a card from the deck
    public void hit(Deck deck, Deck discard) {
        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }

        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        System.out.println("   ---");
        this.printHand();
        Game.pause();
    }

    // Check if the person has a blackjack
    public boolean hasBlackjack() {
        return this.getHand().calculatedValue() == 21;
    }
}
