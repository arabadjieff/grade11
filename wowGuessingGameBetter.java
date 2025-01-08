import java.util.Scanner;
import java.util.Random;

public class wowGuessingGameBetter {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        System.out.println("Please guess a number from 1-100.");
        System.out.println("If you want to quit at any time, just type 'quit'.");

        Scanner scan = new Scanner(System.in);
        String text;
        int choice;
        int attempt = 1;

        while (true) {
            System.out.print("Enter your guess: ");
            if (scan.hasNextInt()) {
                choice = scan.nextInt();

                if (choice == randomNumber) {
                    System.out.println("Your guess is correct. You just won the game. Woohoo!");
                    return;
                } else {
                    if (choice < randomNumber) {
                        System.out.println("Your guess is incorrect. Guess higher.");
                    } else {
                        System.out.println("Your guess is incorrect. Guess lower.");
                    }
                    System.out.println("This was your attempt N." + attempt + ".");
                    attempt++;
                }
            } else {
                text = scan.next();
                if (text.equals("quit")) {
                    System.out.println("You quit the game!");
                    System.out.println("The number was " + randomNumber + ".");
                    return;
                } else {
                    System.out.println("Error: '" + text + "' is not a valid number.");
                }
            }
        }
    }
}
