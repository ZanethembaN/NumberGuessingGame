package za.co.wethinkcode;
import java.util.Random;
import java.util.Scanner;

/**
 * The Main class implements a simple number guessing game with different difficulty levels.
 */
public class Main {

    /**
     * Main method where the execution of the program begins.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Choose your difficulty level:");
        System.out.println("1. Easy (Numbers between 1 and 50)");
        System.out.println("2. Medium (Numbers between 1 and 100)");
        System.out.println("3. Hard (Numbers between 1 and 200)");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        int maxNumber;
        int maxAttempts;
        switch (choice) {
            case 1:
                maxNumber = 50;
                maxAttempts = 5;
                break;
            case 2:
                maxNumber = 100;
                maxAttempts = 7;
                break;
            case 3:
                maxNumber = 200;
                maxAttempts = 10;
                break;
            default:
                maxNumber = 100;
                maxAttempts = 7;
                break;
        }

        int secretNumber = random.nextInt(maxNumber) + 1;
        int attempts = 0;
        boolean hintUsed = false;


        // Game loop to allow multiple guesses within the allowed attempts
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (between 1 and " + maxNumber + "): ");
            int guess = scanner.nextInt();

            // Check if the guess is too low, too high, or correct
            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                break; // Exit the loop if the guess is correct
            }
            attempts++;


            // Provide a hint if half of the attempts have been used and a hint hasn't been used yet
            if (!hintUsed && attempts == (maxAttempts / 2)) {
                System.out.println("Hint: The number is divisible by 2.");
                hintUsed = true;
            }
        }

        // If all attempts are used without guessing the correct number
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber);
        }

        scanner.close();
    }
}
