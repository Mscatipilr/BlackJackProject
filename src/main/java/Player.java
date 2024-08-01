import java.util.Scanner;

// Class representing a player in the game
public class Player extends Person {
    Scanner input;

    // Constructor
    public Player() {
        this.input = new Scanner(System.in);
        super.setName("Player");
    }

    // Player decision making: hit or stand
    public void makeDecision(Deck deck, Deck discard) {
        int decision = 0;
        boolean getNum = true;

        // Loop until a valid decision is made
        while (getNum) {
            try {
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = this.input.nextInt();
                getNum = false;
            } catch (Exception var6) {
                System.out.println("Invalid");
                this.input.next();
            }
        }

        // Perform hit or stand based on the decision
        if (decision == 1) {
            this.hit(deck, discard);
            if (this.getHand().calculatedValue() > 20) {
                return;
            }

            this.makeDecision(deck, discard);
        } else {
            System.out.println("You stand.");
        }
    }
}
