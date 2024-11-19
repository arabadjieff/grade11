public class library {
    public static void main(String[] args) {
        // Task 4: Create two or more Book objects with different attributes.
        Book b1 = new Book("James Orway", "The Book of Butterflies", 321);
        Book b2 = new Book("Ivan Draganov", "Knigata na Kuchetata", 872);
        Book b3 = new Book("Strongor Durpov", "Napoleon in Russia", 113);

        // Task 5: Call the displayDetails method for each object.
        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
    }
}

// Define the Book class
class Book {
    // Task 1: Add three attributes: title, author, and numberOfPages.
    private String title;
    private String author;
    private int numberOfPages;

    // Constructor
    public Book(String initTitle, String initAuthor, int initNumberOfPages) {
    title = initTitle;
    author = initAuthor;
    numberOfPages = initNumberOfPages;
    // Task 2: Initialize the attributes inside this constructor.
    }

    // Task 3: Add a method displayDetails() to print the book's details (title, author, and numberOfPages).
    public void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numberOfPages);
    }
}
