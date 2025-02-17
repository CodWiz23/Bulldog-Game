import java.util.Random;

/**
 * The UniquePlayerAI class extends the abstract Player class.
 * This class implements a strategy where the player rolls a die
 * and accumulates points based on specific conditions:
 * 
 * - If a 6 is rolled, the player's turn ends immediately with 0 points.
 * - The player continues rolling until they reach at least 10 points.
 * - If the score is between 10 and 20, the player has a 50% chance to stop.
 * - If the score reaches 20 or more, the player always stops.
 * 
 * @version Jan 29, 2025
 * @author Abdirahman with the assistance of ChatGPT 4o
 */
public class UniquePlayerAI extends Player {
    
    private Random random = new Random(); // Random generator for decision-making

    /**
     * Constructs a UniquePlayerAI with the specified name.
     * @param name The name of the player.
     */
    public UniquePlayerAI(String name) {
        super(name);
    }

    /**
     * Simulates the player's turn by rolling a die and applying strategy-based decisions.
     * @return The score accumulated for this turn, or 0 if a 6 is rolled.
     */
    @Override
    public int play() {
        int turnScore = 0;
        
        while (true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("   Player " + getName() + " rolled " + roll);

            if (roll == 6) {
                System.out.println("   Rolled a 6! Turn ends with 0 points.");
                return 0;
            }

            turnScore += roll;
            System.out.println("   Current turn score: " + turnScore);

            if (turnScore >= 20) {
                System.out.println("   Player " + getName() + " stops after reaching 20 points.");
                break;
            }

            if (turnScore >= 10 && turnScore < 20 && random.nextBoolean()) {
                System.out.println("   Player " + getName() + " stops randomly.");
                break;
            }
        }

        return turnScore;
    }
}
