import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between " + min + " and " + max + ".");
        System.out.println("Can you guess what it is?");

        int guess;
        int attempts = 0;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in "
                        + attempts + " attempts.");
            }
        } while (guess != randomNumber);

        scanner.close();
    }
}
