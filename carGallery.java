import java.util.Scanner;

public class carGallery {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Car[] carArray = {
            new Car("Toyota", "Camry", 2020, 25000, false),
            new Car("Honda", "Civic", 2016, 15000, true),
            new Car("Ford", "Fusion", 2019, 20000, false),
            new Car("BMW", "X5", 2021, 50000, false)
        };

        int choice;
        do {
            System.out.println("Car Gallery Menu:");
            System.out.println("0. Exit");
            System.out.println("1. Display all cars");
            System.out.println("2. Display most expensive car");
            System.out.println("3. Calculate average price of cars");
            System.out.println("4. Lease a car");
            System.out.print("Enter the option: ");
            choice = read.nextInt();

            switch (choice) {
                case 1:
                    displayAllCars(carArray);
                    break;
                case 2:
                    mostExpensiveCar(carArray);
                    break;
                case 3:
                    System.out.println("Average price: $" + averagePrice(carArray));
                    break;
                case 4:
                    System.out.print("Enter car index: ");
                    int leaseChoice = read.nextInt();
                    leaseCar(carArray, leaseChoice);
                    break;
                case 0:
                    System.out.println("Bye.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        read.close();
    }

    public static void displayAllCars(Car[] cars) {
        for (Car car : cars) {
            car.displayInfo();
        }
    }

    public static void mostExpensiveCar(Car[] cars) {
        Car expensive = cars[0];
        for (Car car : cars) {
            if (car.price > expensive.price) {
                expensive = car;
            }
        }
        System.out.println("Most Expensive Car:");
        expensive.displayInfo();
    }

    public static double averagePrice(Car[] cars) {
        double total = 0;
        for (Car car : cars) {
            total += car.price;
        }
        return total / cars.length;
    }

    public static void leaseCar(Car[] cars, int index) {
        if (index >= 0 && index < cars.length) {
            if (!cars[index].isLeased) {
                cars[index].isLeased = true;
                System.out.println("Car leased successfully.");
            } else {
                System.out.println("Car is already leased.");
            }
        } else {
            System.out.println("Invalid car index.");
        }
    }
}

class Car {
    String make;
    String model;
    int year;
    double price;
    boolean isLeased;

    public Car(String make, String model, int year, double price, boolean isLeased) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = isLeased;
    }

    public void displayInfo() {
        System.out.println(make + " " + model + " (" + year + ") - $" + price + " | Leased: " + (isLeased ? "Yes" : "No"));
    }
}
