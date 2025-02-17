import java.util.Random;

/**
 * The RandomPlayer class extends the abstract Player class.
 * This class implements a strategy where the player makes random decisions
 * on whether to continue rolling or stop.
 * 
 * - The player rolls a six-sided die and accumulates points.
 * - Rolling a 6 immediately ends the turn with 0 points.
 * - After each roll (except a 6), the player has a 50% probability of stopping.
 * - The turn ends when the player either chooses to stop or rolls a 6.
 * 
 * @version Feb 5, 2025
 * @author Abdirahman with the assistance of ChatGPT 4o
 */
public class RandomPlayer extends Player {
    
    private Random random = new Random(); // Random number generator for decision-making

    /**
     * Constructs a RandomPlayer with the specified name.
     * @param name The name of the player.
     */
    public RandomPlayer(String name) {
        super(name);
    }

    /**
     * Simulates the player's turn by rolling a die and deciding randomly whether to continue or stop.
     * 
     * @return The score accumulated during the turn, or 0 if a 6 is rolled.
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

            // 50% chance to stop rolling
            if (random.nextBoolean()) { 
                System.out.println("   Player " + getName() + " chooses to stop.");
                break;
            }
        }

        return turnScore;
    }
}
