import java.util.Scanner;
import java.io.*;

public class groceryList {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        FileWriter writer = new FileWriter(filename);
        while (true) {
            System.out.print("Enter a grocery item (or type 'done'): ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            }
            writer.write(item + "\n");
        }
        writer.close();
    }
}
