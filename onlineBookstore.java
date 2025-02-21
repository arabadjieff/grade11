import java.util.Scanner;

public class onlineBookstore {
    static String[] titles = {"Pod Igoto", "Jelezniqt Svetilnik", "Drundio", "Nemili-nedragi"};
    static double[] prices = {25.99, 19.99, 30.50, 45.75};
    static int[] quantities = {5, 3, 4, 2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Bookstore!");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Purchase Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    displayBooks();
                    break;
                case "2":
                    searchBook(scanner);
                    break;
                case "3":
                    purchaseBook(scanner);
                    break;
                case "4":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void displayBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " - $" + prices[i] + " (Stock: " + quantities[i] + ")");
        }
    }

    public static void searchBook(Scanner scanner) {
        System.out.print("Enter book title to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(query)) {
                System.out.println("Found: " + titles[i] + " - $" + prices[i] + " (Stock: " + quantities[i] + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public static void purchaseBook(Scanner scanner) {
        displayBooks();
        System.out.print("Enter the number of the book you want to buy: ");
        String input = scanner.nextLine();

        if (!isNumber(input)) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        int choice = Integer.parseInt(input) - 1;
        if (choice < 0 || choice >= titles.length) {
            System.out.println("Invalid book selection.");
            return;
        }

        if (quantities[choice] == 0) {
            System.out.println("Sorry, this book is out of stock.");
            return;
        }

        System.out.print("Enter payment amount: ");
        String paymentInput = scanner.nextLine();

        if (!isNumber(paymentInput)) {
            System.out.println("Invalid payment amount.");
            return;
        }

        double payment = Double.parseDouble(paymentInput);
        if (payment < prices[choice]) {
            System.out.println("Insufficient funds. Purchase failed.");
        } else {
            quantities[choice]--;
            System.out.println("Purchase successful! Your change: $" + (payment - prices[choice]));
        }
    }

    public static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
}
