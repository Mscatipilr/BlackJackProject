// Enum representing card suits with their names
public enum Suit {

    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

    String suitName;

    // Constructor
    private Suit(String suitName) {
        this.suitName = suitName;
    }

    // Return the name of the suit
    public String toString() {
        return this.suitName;
    }
}
