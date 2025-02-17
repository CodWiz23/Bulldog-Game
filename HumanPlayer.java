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
    }
}
