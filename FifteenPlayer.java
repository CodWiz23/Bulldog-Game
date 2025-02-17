/**
 * The FifteenPlayer class extends the abstract Player class.

 * This class implements a strategy where the player continues rolling
 * until they accumulate at least 15 points in a single turn.
 * 
 * - The player rolls a six-sided die and accumulates points.
 * - If the player rolls a 6, the turn immediately ends with 0 points.
 * - The player keeps rolling until they reach at least 15 points.
 * - Once at least 15 points are reached, the player automatically stops.
 * 
 * @version Feb 5, 2025
 * @author Abdirahman with the assistance of ChatGPT 4o
 */
public class FifteenPlayer extends Player {

	/**
	 * Constructs a FifteenPlayer with the specified name.
	 * @param name The name of the player.
	 */
	public FifteenPlayer(String name) {
		super(name);
	}

	/**
	 * Simulates the player's turn by rolling a die until at least 15 points are accumulated or a 6 is rolled.
	 * 
	 * @return The score accumulated during the turn, or 0 if a 6 is rolled.
	 */
	@Override
	public int play() {
		int turnScore = 0;

		while (turnScore < 15) {
			int roll = (int) (Math.random() * 6 + 1);
			System.out.println("   Player " + getName() + " rolled " + roll);

			if (roll == 6) {
				System.out.println("   Rolled a 6! Turn ends with 0 points.");
				return 0;
			}

			turnScore += roll;
			System.out.println("   Current turn score: " + turnScore);
		}

		System.out.println("   Player " + getName() + " stops after reaching at least 15 points.");
		return turnScore;
	}

 * This class implements a game mechanic where the player attempts to reach a score of at least 15 
 * without rolling a 6. If the player rolls a 6, they lose their turn and their score for that turn. 
 * The player can continue rolling until their cumulative score for the turn reaches or exceeds 15.
 * 
 * @version Jan 29, 2025
 * @author Abdirahman
 */
public class FifteenPlayer extends Player {

    /**
     * Constructor for the FifteenPlayer class.
     * 
     * @param name The name of the player.
     */
    public FifteenPlayer(String name) {
        super(name); // Call the constructor of the Player superclass
    }

    /**
     * Implements the play method for the FifteenPlayer class.
     * The player rolls a six-sided die repeatedly to accumulate points until 
     * the turn score reaches or exceeds 15, or the player rolls a 6 and loses all points.
     * 
     * @return The total score for the turn. Returns 0 if the player rolls a 6.
     */
    @Override
    public int play() {
        int turnScore = 0; // Initialize the score for the current turn

        // Player continues to roll until the score reaches or exceeds 15
        while (turnScore < 15) {
            int roll = (int) (Math.random() * 6 + 1); // Roll a six-sided die (values 1-6)
            System.out.println(getName() + " rolled " + roll);

            // If the player rolls a 6, they lose all points and their turn ends
            if (roll == 6) {
                System.out.println(getName() + " rolled a 6 and lost all points this turn.");
                return 0; // Return 0 as the score for the turn
            }

            // Add the roll value to the cumulative turn score
            turnScore += roll;
            System.out.println(getName() + "'s cumulative turn score is " + turnScore 
                               + " and chose to play another turn!");
        }

        // Turn ends when the cumulative score reaches or exceeds 15
        System.out.println(getName() + " ends the turn with a score of " + turnScore);
        return turnScore; // Return the final turn score
    }
}
