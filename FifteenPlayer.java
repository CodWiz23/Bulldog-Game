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
}
