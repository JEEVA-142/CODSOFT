import java.util.*;

public class Main {  // changed from NumberGame to Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int lower = 1, upper = 100, maxAttempts = 7;
        int roundsWon = 0, totalRounds = 0;
        String playAgain;
        
        System.out.println("=== NUMBER GUESSING GAME ===");
        
        do {
            int number = rand.nextInt(upper - lower + 1) + lower;
            int attempts = 0;
            totalRounds++;
            boolean guessed = false;
            
            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("I'm thinking of a number between " + lower + " and " + upper + ".");
            System.out.println("You have " + maxAttempts + " attempts.");
            
            while(attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                
                if(!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                    continue;
                }
                
                int guess = sc.nextInt();
                attempts++;
                
                if(guess == number) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    roundsWon++;
                    guessed = true;
                    break;
                } else if(guess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                if(attempts == maxAttempts && !guessed) {
                    System.out.println("Out of attempts! The number was " + number + ".");
                }
            }
            
            int score = guessed ? (maxAttempts - attempts + 1) : 0;
            System.out.println("Score this round: " + score);
            System.out.println("Total rounds won: " + roundsWon + "/" + totalRounds);
            
            System.out.print("\nPlay another round? (y/n): ");
            playAgain = sc.next();
            
        } while(playAgain.equalsIgnoreCase("y"));
        
        System.out.println("\nFinal Score: " + roundsWon + " wins out of " + totalRounds + " rounds.");
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
