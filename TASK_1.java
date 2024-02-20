import java.util.Scanner;
import java.util.Random;

public class TASK_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("*** Welcome ***");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("You've guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Too high");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("\nYour current score: " + score);
            System.out.print("Do you want to play again? ");
            System.out.println("yes / no :");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("*** Thanks for playing ***");
        scanner.close();
    }
}
