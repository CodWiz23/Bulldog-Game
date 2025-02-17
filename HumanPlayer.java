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
 * @version Jan 29, 2025
 * @author Abdirahman
 */
import java.util.Scanner;

public class HumanPlayer extends Player {

    /**
     * Constructor for the HumanPlayer class.
     * 
     * @param name The name of the player.
     */
    public HumanPlayer(String name) {
        super(name); // Call the constructor of the Player superclass
    }

    /**
     * Implements the play method for the HumanPlayer class.
     * The user rolls a six-sided die, accumulating points until they choose to stop
     * or roll a 6. Rolling a 6 results in a loss of all points for the turn.
     * 
     * @return The total score for the turn. Returns 0 if the user rolls a 6.
     */
    @Override
    public int play() {
        int turnScore = 0; // Initialize the turn score
        Scanner scan = new Scanner(System.in); // Scanner for user input

        // Game loop: The user can continue rolling until they stop or roll a 6
        while (true) {
            // Roll a six-sided die and display the result
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled " + roll);

            // Check if the player loses the turn by rolling a 6
            if (roll == 6) {
                System.out.println("Womp Womp Womp...you lose. Better luck next time!");
                System.out.println(getName() + "'s score: " + turnScore);
                scan.close(); // Close the scanner before returning
                return 0; // End the turn with a score of 0
            }

            // Add the roll value to the turn score
            turnScore += roll;
            System.out.println("Current Score: " + turnScore);

            // Ask the user if they want to roll again
            System.out.println("Dare to play another turn? (yes/no)");
            String response = scan.nextLine().toLowerCase();

            // If the user chooses to stop, end the turn and return the score
            if (response.equals("no")) {
                System.out.println(getName() + " ends the turn with a score of " + turnScore);
                scan.close(); // Close the scanner before returning
                return turnScore;
            }

            // Validate input for unexpected responses
            while (!response.equals("yes") && !response.equals("no")) {
                System.out.println("Invalid input! Please type 'yes' or 'no':");
                response = scan.nextLine().toLowerCase();
            }
        }
    }
}
