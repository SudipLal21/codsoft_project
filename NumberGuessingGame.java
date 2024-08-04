import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 10;
            boolean hasWon = false;

            System.out.println("I have generated a random number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            System.out.println(); // Blank line

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                try {
                    int userGuess = scanner.nextInt();
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                    numberOfAttempts++;

                    if (userGuess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number.");
                        System.out.println(); // Blank line
                        hasWon = true;
                        roundsWon++;
                        break;
                    }

                    System.out.println("Attempts left: " + (maxAttempts - numberOfAttempts));
                    System.out.println(); // Blank line
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    System.out.println(); // Blank line
                    scanner.next(); // Clear the invalid input
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Rounds Won: " + roundsWon);

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! You won " + roundsWon + " rounds. Goodbye.");
        scanner.close();
    }
}