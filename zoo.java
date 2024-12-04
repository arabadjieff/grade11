public class zoo {
    public static void main(String[] args) {
        //create habitats
        Habitat savannah = new Habitat("Savannah", 1000, 30);
        Habitat rainforest = new Habitat("Rainforest", 800, 25);
        Habitat jungle = new Habitat("Jungle", 1200, 35);

        //create animals
        Animal lion = new Animal("Ivan", "Lion", 5, jungle);
        Animal elephant = new Animal("Tsanko", "Elephant", 10, savannah);
        Animal parrot = new Animal("Pedalski", "Parrot", 2, rainforest);
        Animal monkey = new Animal("Jorkata", "Monkey", 4, rainforest);

        //create zoo and add animals
        Zoo zoo = new Zoo();
        zoo.addAnimal1(lion);
        zoo.addAnimal2(elephant);
        zoo.addAnimal3(parrot);
        zoo.addAnimal4(monkey);

        //hire staff
        Staff zookeeper1 = new Staff("Iordan", "Zookeeper");
        Staff zookeeper2 = new Staff("Jana", "Hygienist");

        //assign staff
        zookeeper1.assignStaff(savannah);
        zookeeper2.assignStaff(rainforest);

        //feed animals
        lion.eat("meat", zookeeper1);
        elephant.eat("fruits", zookeeper1);
        parrot.eat("seeds", zookeeper2);
        monkey.eat("bananas", zookeeper2);
    }
}

class Animal {
    String name;
    String species;
    int age;
    Habitat habitat;

    public Animal(String name, String species, int age, Habitat habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    void eat(String food, Staff staff) {
        System.out.println(name + " is fed " + food + " by " + staff.getName());
    }
}

class Habitat {
    String type;
    int size;
    int temperature;

    public Habitat(String type, int size, int temperature) {
        this.type = type;
        this.size = size;
        this.temperature = temperature;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getTemperature() {
        return temperature;
    }
}

class Zoo {
    Animal animal1;
    Animal animal2;
    Animal animal3;
    Animal animal4;

    public void addAnimal1(Animal animal) {
        this.animal1 = animal;
        System.out.println(animal.getName() + " the " + animal.getSpecies() + " added to the zoo as Animal 1.");
    }

    public void addAnimal2(Animal animal) {
        this.animal2 = animal;
        System.out.println(animal.getName() + " the " + animal.getSpecies() + " added to the zoo as Animal 2.");
    }

    public void addAnimal3(Animal animal) {
        this.animal3 = animal;
        System.out.println(animal.getName() + " the " + animal.getSpecies() + " added to the zoo as Animal 3.");
    }

    public void addAnimal4(Animal animal) {
        this.animal4 = animal;
        System.out.println(animal.getName() + " the " + animal.getSpecies() + " added to the zoo as Animal 4.");
    }

    public Animal getAnimal1() {
        return animal1;
    }

    public Animal getAnimal2() {
        return animal2;
    }

    public Animal getAnimal3() {
        return animal3;
    }

    public Animal getAnimal4() {
        return animal4;
    }
}

class Staff {
    String name;
    String role;
    Habitat assignedHabitat;

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Habitat getAssignedHabitat() {
        return assignedHabitat;
    }

    void assignStaff(Habitat habitat) {
        this.assignedHabitat = habitat;
        System.out.println(name + " is assigned to " + habitat.getType());
    }
}
