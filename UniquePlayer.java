/**
 * 
 * The UniquePlayerAI class extends the abstract Player class.
 * This class implements a strategy where the player rolls a die
 * and accumulates points based on specific conditions:
 * 
 * - If a 6 is rolled, the player's turn ends immediately with 0 points.
 * - The player continues rolling until they reach at least 21 points.
 * - If the score reaches 21 or more, the player always stops.
 * 
 * @author abdirahman 
 */
public class UniquePlayer extends Player {

	public UniquePlayer() {
		this("UPlayer");
	}

	public UniquePlayer(String name) {
		super(name);
	}

	@Override
	public int play() {
		int turnScore = 0;
		while(true) {
			int roll = (int) (Math.random() * 6 + 1); // Roll a six-sided die
			System.out.println(getName() + " rolled " + roll);

			if (roll == 6) {
				System.out.println("Womp Womp Womp...you lose all your points from this turn. Better luck next time!");
				System.out.println(getName() + "'s score: " + turnScore);
				return 0; // End the turn with a score of 0
			}
			if(turnScore + roll > 21) {
				System.out.println("Womp Womp Womp...you lose all your points from this turn. Better luck next time!");
				System.out.println(getName() + "'s score: " + turnScore);
				return 0; // End the turn with a score of 0
			}
			if(turnScore + roll == 21){
				turnScore += roll;
				System.out.println("Your turn is over for this round.");
				return turnScore;
			}else {
				turnScore += roll;
				System.out.println("Current Score: " + turnScore);

			}


		}
	}

}
