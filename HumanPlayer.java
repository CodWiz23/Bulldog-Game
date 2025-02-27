
import java.util.Scanner;

/**
 * The HumanPlayer class extends the abstract Player class.
 * This class allows a user to control the player manually.
 * 
 * - The user decides whether to continue rolling or stop after each roll.
 * - Rolling a 6 ends the turn with 0 points.
 * - The user accumulates points until they choose to stop or roll a 6.
 * 
 * @version Jan 29, 2025
 * @author Abdirahman with the assistance of ChatGPT 4o
 */
public class HumanPlayer extends Player {
    
    /**
     * Constructs a HumanPlayer with the specified name.
     * @param name The name of the player.
     */
    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Allows the user to take a turn, rolling the die and deciding whether to continue or stop.
     * @return The score accumulated during the turn, or 0 if a 6 is rolled.
     */
    @Override
    public int play() {
        Scanner scanner = new Scanner(System.in);
        int turnScore = 0;
        boolean continueRolling = true;

        while (continueRolling) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("   Player " + getName() + " rolled " + roll);

            if (roll == 6) {
                System.out.println("   Rolled a 6! Turn ends with 0 points.");
                return 0;
            }

            turnScore += roll;
            System.out.println("   Current turn score: " + turnScore);

            System.out.print("   Continue rolling? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            continueRolling = response.equals("y");
        }

        System.out.println("   Player " + getName() + " ended turn with " + turnScore + " points.");
        return turnScore;

/**
 * The HumanPlayer class extends the abstract Player class. 
 * This class implements a turn-based game mechanic where the user can roll a die
 * and accumulate points until they either choose to stop or lose their turn.
 * 
 * Game Rules:
 * - Rolling a 6 results in an automatic loss of all points for the turn.
 * - The user can continue rolling until they choose to stop or roll a 6.
 * - Points are accumulated as long as the user does not roll a 6 or stop voluntarily.
 * 
 * @version Feb 17, 2025
 * @author Abdirahman
 */
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner; // Reference to a shared Scanner instance

    /**
     * Constructor for HumanPlayer.
     * 
     * @param name    The player's name.
     * @param scanner The Scanner instance shared across the game.
     */
    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner; // Assign the shared Scanner instance
    }

    /**
     * Plays the player's turn, allowing them to roll the dice and decide whether to continue.
     * The player rolls until they choose to stop or roll a 6 (which causes them to lose their turn).
     * 
     * @return The player's accumulated turn score.
     */
    @Override
    public int play() {
        int turnScore = 0; // Initialize turn score

        while (true) {
            // Roll a six-sided die (1-6)
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled " + roll);

            // If the player rolls a 6, they lose all points for this turn
            if (roll == 6) {
                System.out.println("Oops! You rolled a 6. You lose all points from this turn.");
                System.out.println(getName() + "'s turn ends with 0 points.");
                return 0; // End turn with a score of 0
            }

            // Add roll value to the turn score
            turnScore += roll;
            System.out.println("Current Score: " + turnScore);

            // Ask player if they want to continue rolling
            System.out.print("Dare to play another turn? (yes/no): ");

            // Read the user's response
            String response = scanner.next(); // Read a single word input
            scanner.nextLine(); // Consume any leftover input (fixes Scanner issue)

            // If player types anything other than "yes", end their turn
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Display final score for this turn
        System.out.println(getName() + " ends the turn with a score of " + turnScore);
        return turnScore; // Return the accumulated score

    }
}
