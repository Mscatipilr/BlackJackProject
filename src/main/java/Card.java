public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public int getValue() {
        return this.rank.rankValue;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        String value = String.valueOf(this.rank);
        return "[" + value + " of " + String.valueOf(this.suit) + "] (" + this.getValue() + ")";
    }

    public int compareTo(Card c) {
        if (this.getValue() > c.getValue()) {
            return 1;
        } else {
            return this.getValue() < c.getValue() ? -1 : 0;
        }
    }
}