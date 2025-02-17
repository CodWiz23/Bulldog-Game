/**
 * 
 * The RandomPlayer class extends the abstract Player class. 
 * In this class, the player's decision to continue rolling the die or stop is made randomly.
 * 
 * Game Rules:
 * - The player rolls a six-sided die to accumulate points.
 * - If the player rolls a 6, they lose all points for the turn, and the turn ends.
 * - After each roll (except rolling a 6), a random choice is made:
 *   - If the random choice is 0, the player continues rolling.
 *   - If the random choice is 1, the player stops, and their accumulated score is returned.
 * 
 * This class simulates a player who makes decisions purely based on random outcomes.
 * 
 * @version Jan 29, 2025
 * @author Abdirahman
 */
import java.util.Scanner;

public class RandomPlayer extends Player {

    /**
     * Constructor for the RandomPlayer class.
     * 
     * @param name The name of the player.
     */
    public RandomPlayer(String name) {
        super(name); // Call the constructor of the Player superclass
    }

    /**
     * Implements the play method for the RandomPlayer class.
     * The player rolls a six-sided die and accumulates points until either:
     * - They roll a 6 and lose all points for the turn, or
     * - A random decision stops the player from rolling further.
     * 
     * @return The total score for the turn. Returns 0 if the player rolls a 6.
     */
    @Override
    public int play() {
        int turnScore = 0; // Initialize the turn score
        Scanner scan = new Scanner(System.in); // Scanner for user input (unused in this implementation)

        while (true) {
            // Roll a six-sided die and display the result
            int roll = (int) (Math.random() * 6 + 1); 
            System.out.println(getName() + " rolled " + roll);

            // Check if the player rolls a 6 and loses the turn
            if (roll == 6) {
                System.out.println("Womp Womp Womp...you lose. Better luck next time!");
                System.out.println(getName() + "'s score: " + turnScore);
                return 0; // End the turn with a score of 0
            } else {
                // Add the roll value to the cumulative turn score
                turnScore += roll;
                System.out.println("Current Score: " + turnScore);
            }

            // Randomly decide whether the player continues rolling
            int randChoice = (int) (Math.random() * 2); // Generates 0 or 1 randomly

            if (randChoice == 0) {
                // Player randomly chooses to continue rolling
                System.out.println("You get to play another round!");
            } else {
                // Player randomly chooses to stop rolling
                System.out.println(getName() + " ends the turn with a score of " + turnScore);
                return turnScore; // Return the total score for the turn
            }
        }
    }
}
