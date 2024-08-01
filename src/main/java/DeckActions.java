// Interface for deck actions
public interface DeckActions {
    // Shuffle the deck
    public void shuffle();

    // Deal the next card from the deck
    public Card dealNextCard();

    // Print a certain number of cards from the deck
    public void printDeck(int numToPrint);
}
