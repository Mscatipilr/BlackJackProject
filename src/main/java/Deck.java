import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class Deck implements DeckActions {

    private ArrayList<Card> myCards;
    private int numCards;

    public Deck() {
        this.myCards = new ArrayList<>();
        this.numCards = 0;
    }

    public Deck(boolean makeDeck) {
        this.myCards = new ArrayList<>();
        if (makeDeck) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    this.myCards.add(new Card(suit, rank));
                }
            }
            this.numCards = this.myCards.size();
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.myCards, new Random());
    }

    @Override
    public Card dealNextCard() {
        if (this.numCards == 0) {
            return null;
        } else {
            this.numCards--;
            return this.myCards.remove(0);
        }
    }

    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < numToPrint && i < this.myCards.size(); i++) {
            System.out.println(this.myCards.get(i));
        }
    }

    public void addCard(Card card) {
        this.myCards.add(card);
        this.numCards++;
    }

    public void addCards(ArrayList<Card> cards) {
        this.myCards.addAll(cards);
        this.numCards += cards.size();
    }

    public boolean hasCards() {

        return !this.myCards.isEmpty();
    }

    public int cardsLeft() {
        return this.myCards.size();
    }

    public void emptyDeck() {
        this.myCards.clear();
        this.numCards = 0;
    }

    public void reloadDeckFromDiscard(Deck discard) {
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }

    public ArrayList<Card> getCards() {
        return this.myCards;
    }
}
