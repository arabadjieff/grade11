class Vehicle {
    String name;

    Vehicle(String name) {
        this.name = name;
    }

    void displayDetails() {
        System.out.println("Vehicle Name: " + name);
    }

    double calculateSpeed() {
        return 0.0;
    }
}

class Car extends Vehicle {
    int horsepower;

    Car(String name, int horsepower) {
        super(name);
        this.horsepower = horsepower;
    }

    @Override
    void displayDetails() {
        System.out.println("Car Name: " + name + ", Horsepower: " + horsepower);
    }

    @Override
    double calculateSpeed() {
        return horsepower * 0.5;
    }
}

class Bicycle extends Vehicle {
    int gearCount;

    Bicycle(String name, int gearCount) {
        super(name);
        this.gearCount = gearCount;
    }

    @Override
    void displayDetails() {
        System.out.println("Bicycle Name: " + name + ", Gears: " + gearCount);
    }

    @Override
    double calculateSpeed() {
        return gearCount * 2.0;
    }
}

public class carDealership {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Kolichka", 150);
        vehicles[1] = new Bicycle("Kolelce", 21);
        vehicles[2] = new Car("Super Kolichka", 130);

        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Estimated Speed: " + v.calculateSpeed() + " km/h");
            System.out.println();
        }
    }
}
