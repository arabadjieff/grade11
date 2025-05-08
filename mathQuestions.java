import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class mathQuestions {
    public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        FileWriter writer = new FileWriter(name + "-answers.txt");

        for (int i = 0; i < 5; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int correct = a + b;

            System.out.print(a + " + " + b + " = ");
            int answer = scanner.nextInt();

            if (answer == correct) {
                writer.write(a + " + " + b + " = " + answer + " (correct)\n");
            } else {
                writer.write(a + " + " + b + " = " + answer + " (incorrect)\n");
            }
        }

        writer.close();
        System.out.println("Answers saved!");
    }
}
