// Class representing the game logic
public class Game {
    private Deck deck = new Deck(true);
    private Deck discarded = new Deck();
    private Dealer dealer = new Dealer();
    private Player player = new Player();
    private int wins;
    private int losses;
    private int pushes;

    // Constructor
    public Game() {
        this.deck.shuffle();
        this.startRound();
    }

    // Start a new round of the game
    private void startRound() {
        // Print round results if any rounds have been played
        if (this.wins > 0 || this.losses > 0 || this.pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + this.wins + " • Losses: " + this.losses + " • Pushes: " + this.pushes);
            System.out.println("   ---");
            this.dealer.getHand().discardHandToDeck(this.discarded);
            this.player.getHand().discardHandToDeck(this.discarded);
        }

        // Reload deck from discard pile if necessary
        if (this.deck.cardsLeft() < 4) {
            this.deck.reloadDeckFromDiscard(this.discarded);
        }

        // Deal initial cards to dealer and player
        this.dealer.getHand().takeCardFromDeck(this.deck);
        this.dealer.getHand().takeCardFromDeck(this.deck);
        this.player.getHand().takeCardFromDeck(this.deck);
        this.player.getHand().takeCardFromDeck(this.deck);
        this.dealer.printFirstHand();
        this.player.printHand();

        // Check for blackjack conditions
        if (this.dealer.hasBlackjack()) {
            this.dealer.printHand();
            if (this.player.hasBlackjack()) {
                System.out.println("You both have 21 - Push.");
                this.pushes++;
                this.startRound();
            } else {
                System.out.println("Dealer has BlackJack. You lose.");
                this.dealer.printHand();
                this.losses++;
                this.startRound();
            }
        }

        if (this.player.hasBlackjack()) {
            System.out.println("You have Blackjack! You win!");
            this.wins++;
            this.startRound();
        }

        // Player decision making
        this.player.makeDecision(this.deck, this.discarded);

        // Check for player bust
        if (this.player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21.");
            ++this.losses;
            this.startRound();
        }

        // Dealer decision making
        this.dealer.printHand();
        while (this.dealer.getHand().calculatedValue() < 17) {
            this.dealer.hit(this.deck, this.discarded);
        }

        // Determine round outcome
        if (this.dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts");
            ++this.wins;
        } else if (this.dealer.getHand().calculatedValue() > this.player.getHand().calculatedValue()) {
            System.out.println("You lose.");
            ++this.losses;
        } else if (this.player.getHand().calculatedValue() > this.dealer.getHand().calculatedValue()) {
            System.out.println("You win.");
            ++this.wins;
        } else {
            System.out.println("Push.");
            ++this.pushes;
        }

        this.startRound();
    }

    // Pause the game for a short period
    public static void pause() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
