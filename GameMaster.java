import java.util.ArrayList;
import java.util.Scanner;

/**
 * GameMaster - The main class for the Bulldog Game.
 * This program allows users to select a player profile and play a turn-based game.
 * The game continues until one player reaches exactly 0 points.
 * Multiple players can participate, each with unique gameplay strategies.
 * 
 * @version Feb 17, 2025
 * @author Abdirahman Mohamed
 */
public class GameMaster {
    
    private static final int STARTING_SCORE = 104; // Initial score for all players
    private static final Scanner gameUser = new Scanner(System.in); // Single scanner instance

    /**
     * The main method manages user interaction, game initialization, and the gameplay loop.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Bulldog Game!");
        
        // Get the number of players
        System.out.print("Enter the number of players: ");
        while (!gameUser.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            gameUser.next(); // Discard invalid input
        }
        int numPlayers = gameUser.nextInt();
        gameUser.nextLine(); // Clear buffer

        // Initialize players list
        ArrayList<Player> players = new ArrayList<>();
        
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter Player " + i + "'s name: ");
            String playerName = gameUser.nextLine();

            System.out.println("Select a player type for " + playerName + ":");
            System.out.println("1. FifteenPlayer\n2. UniquePlayer\n3. WimpPlayer\n4. HumanPlayer\n5. RandomPlayer");
            
            while (!gameUser.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                gameUser.next(); // Discard invalid input
            }
            int choice = gameUser.nextInt();
            gameUser.nextLine(); // Clear buffer

            Player player;
            switch (choice) {
                case 1: player = new FifteenPlayer(playerName); break;
                case 2: player = new UniquePlayer(playerName); break;
                case 3: player = new WimpPlayer(playerName); break;
                case 4: player = new HumanPlayer(playerName, gameUser); break;
                case 5: player = new RandomPlayer(playerName); break;
                default:
                    System.out.println("Invalid choice! Defaulting to HumanPlayer.");
                    player = new HumanPlayer(playerName, gameUser);
            }

            player.setScore(STARTING_SCORE); // Set initial score to 104
            players.add(player);
        }

        // Game loop: Continue playing until one player reaches exactly 0
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                System.out.println("\n" + player.getName() + "'s turn:");
                int roundScore = player.play();
                
                // Check if the new score would go below 0
                if (player.getScore() - roundScore < 0) {
                    System.out.println(player.getName() + " cannot go below 0. Turn ends, and points are not deducted.");
                    continue;
                }

                // Subtract round score and **update** player's total score
                int newScore = player.getScore() - roundScore;
                player.setScore(newScore); 
                System.out.println(player.getName() + "'s total score: " + newScore);

                //Ensure the game ends when a player reaches **exactly** 0
                if (newScore <= 0) {
                    System.out.println("\n🎉 Congratulations " + player.getName() + "! You have won the Bulldog Game! 🎉");
                    gameWon = true;
                    break; // End game loop
                }
            }
        }

        // Ask the users if they want to play again
        System.out.print("\nDo you want to play again? (yes/no): ");
        String response = gameUser.nextLine();
        
        if (response.equalsIgnoreCase("yes")) {
            main(args); // Restart the game
        } else {
            System.out.println("Thank you for playing Bulldog Game!");
            gameUser.close(); // Close scanner before exiting
        }
    }
}
