public class addressbookExtended  {
    public static void main(String[] args) {
        // Task 6: Create more objects and test the methods
        Person p1 = new Person("Eda", "eda@gmail.com", "123-456-7890", "13");
        p1.print();
        Person p2 = new Person("Hannah", "hannah@gmail.com", "404-899-9955", "23");
        p2.print();
        Person p3 = new Person("Maria", "maria@gmail.com", "563-839-2965", "11");
        p3.print();
        Person p4 = new Person("Kamen", "pedalski@gmail.com", "473-472-8213", "9");
        p4.print();
        p2.update("montana@gmail.com");
        
        // Task 8: Test the updateEmail method
    }
}

// Define the Person class here
class Person {
    // Instance variables
    private String name;
    private String email;
    private String phoneNumber;
    private String age;

    // Task 1: Add a new attribute (e.g., age)

    // Constructor: Initialize Person data
    public Person(String initName, String initEmail, String initPhone, String initAge) { // Task 2: modify method signature to include your new attribute.
        name = initName;
        email = initEmail;
        phoneNumber = initPhone;
        age = initAge;
        // Task 3: Assign a default value to the new attribute here.
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age:" + age);

        // Task 4: Print the new attribute here
    }

    // Task 5: Add getter methods to access and return each attribute individually. Here's an example:
    public String getEmail() {
        return email;
    }

     public String getName() {
        return name;
    }
     public String getPhoneNumber() {
        return phoneNumber;
    }
     public String getAge() {
        return age;
    }

    // Task 7: Add a method to update the email
    public void update(String newEmail){
        email = newEmail;
    }
}
