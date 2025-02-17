import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Prog2 class contains the main method to run the Bulldog game.
 * It allows the user to set up and play a game with multiple players of different types.
 * 
 * - The user selects the number of players.
 * - The user chooses a player type for each player.
 * - The game runs until a player reaches 104 points.
 * - Scores are displayed after each round.
 * 
 * @version Jan 29, 2025
 * @author Abdirahman with the assistance of ChatGPT 4o
 */
public class Prog2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        
        // Get the number of players
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Create players based on user selection
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Select a type for Player " + i + ":");
            System.out.println("1. HumanPlayer");
            System.out.println("2. RandomPlayer");
            System.out.println("3. FifteenPlayer");
            System.out.println("4. UniquePlayerAI");
            System.out.println("5. WimpPlayer");
            System.out.println("6. UniquePlayer");
            System.out.print("Enter your choice (1-6): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            
            switch (choice) {
                case 1:
                    players.add(new HumanPlayer(name));
                    break;
                case 2:
                    players.add(new RandomPlayer(name));
                    break;
                case 3:
                    players.add(new FifteenPlayer(name));
                    break;
                case 4:
                    players.add(new UniquePlayerAI(name));
                    break;
                case 5:
                    players.add(new WimpPlayer(name));
                    break;
                case 6:
                    players.add(new UniquePlayer(name));
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to RandomPlayer.");
                    players.add(new RandomPlayer(name));
                    break;
            }
        }

        // Play the game
        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("\n--- " + player.getName() + "'s Turn ---");
                int turnScore = player.play();
                player.setScore(player.getScore() + turnScore);
                
                System.out.println(player.getName() + "'s total score: " + player.getScore());

                // Check if player has reached or exceeded 104 points
                if (player.getScore() >= 104) {
                    System.out.println("\n*** " + player.getName() + " WINS THE GAME! ***");
                    gameOver = true;
                    break;
                }
            }
        }

        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " points");
        }

        System.out.println("Game Over!");
        scanner.close();
    }
}
