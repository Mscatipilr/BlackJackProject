import java.util.ArrayList;
import java.util.Iterator;

// Class representing a hand of cards
public class Hand {
    // List of cards in the hand
    private ArrayList<Card> hand = new ArrayList<>();

    // Constructor
    public Hand() {
    }

    // Take a card from the deck and add it to the hand
    public void takeCardFromDeck(Deck deck) {
        this.hand.add(deck.dealNextCard());
    }

    // Discard all cards in the hand to the discard deck
    public void discardHandToDeck(Deck discardDeck) {
        discardDeck.addCards(this.hand);
        this.hand.clear();
    }

    // Return a string representation of the hand
    public String toString() {
        String output = "";

        // Iterate over the hand and append each card to the output string
        Card card;
        for (Iterator var2 = this.hand.iterator(); var2.hasNext(); output = output + String.valueOf(card) + " - ") {
            card = (Card) var2.next();
        }

        return output;
    }

    // Calculate the value of the hand
    public int calculatedValue() {
        int value = 0;
        int aceCount = 0;

        // Sum the value of the cards in the hand
        Iterator var3 = this.hand.iterator();
        while (var3.hasNext()) {
            Card card = (Card) var3.next();
            value += card.getValue();
            if (card.getValue() == 11) {
                ++aceCount;
            }
        }

        // Adjust for aces if value is over 21
        if (value > 21 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                --aceCount;
                value -= 10;
            }
        }

        return value;
    }

    // Get a card from the hand by index
    public Card getCard(int idx) {
        return (Card) this.hand.get(idx);
    }
}
