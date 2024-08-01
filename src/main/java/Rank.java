// Enum representing card ranks with their names and values
public enum Rank {

    ACE("Ace", 11),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10);

    String rankName;
    int rankValue;

    // Constructor
    private Rank(String rankName, int rankValue) {
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    // Return the name of the rank
    public String toString() {
        return this.rankName;
    }
}
