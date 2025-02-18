import java.util.Scanner;

public class vendingMachine {
    static String[] names = {"Pepsi", "Pringles", "Skittles", "Airan"};
    static double[] prices = {1.50, 1.00, 0.75, 2.00};
    static int[] quantities = {3, 3, 3, 3};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showItems();
            System.out.print("Select item number (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!isNumber(input)) {
                System.out.println("Invalid input. Enter a number!");
                continue;
            }

            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > names.length) {
                System.out.println("Invalid choice. Pick a valid item!");
                continue;
            }

            processPurchase(choice - 1, scanner);
        }
    }

    public static void showItems() {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - $" + prices[i] + " (Qty: " + quantities[i] + ")");
        }
    }

    public static void processPurchase(int itemIndex, Scanner scanner) {
        if (quantities[itemIndex] == 0) {
            System.out.println("Out of stock.");
            return;
        }

        System.out.print("Give money: ");
        String input = scanner.nextLine();

        if (!isNumber(input)) {
            System.out.println("Invalid amount.");
            return;
        }

        double money = Double.parseDouble(input);
        if (money < prices[itemIndex]) {
            System.out.println("Not enough money.");
        } else {
            quantities[itemIndex]--;
            System.out.println("Item dispensed. Change: " + (money - prices[itemIndex]));
        }
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                return false;
            }
        }
        return !str.isEmpty();
    }
}
