/**
 * 
 * The UniquePlayer class extends the abstract Player class, implementing a modified version of 
 * the Bulldog game with mechanics similar to Blackjack. Players aim to reach exactly 21 points 
 * without rolling a 6. If a player rolls a 6, they lose their turn and forfeit all points 
 * accumulated during that turn. If their total score exceeds 21, their turn ends, but they keep 
 * their accumulated points.
 * 
 * @version Jan 29, 2025
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

			if(turnScore + roll >= 21){
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
