import java.util.Scanner;

public class simpleLibrary {
    public static void displayLibrary(Book[] books) {
        System.out.println("Library:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }

    public static void borrowBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        int bookIndex = findBookByTitle(books, title);

        if (bookIndex != -1) {
            System.out.print("Enter your name: ");
            String borrowerName = scanner.nextLine();
            books[bookIndex].borrowBook(borrowerName);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void returnBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();
        int bookIndex = findBookByTitle(books, title);

        if (bookIndex != -1) {
            books[bookIndex].returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public static int findBookByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Book[] library = {
            new Book("Pod Igoto", "Ivan Vazov", 1893),
            new Book("Nemili-nedragi", "Ivan Vazov", 1883),
            new Book("Physics of Sorrow", "Georgi Gospodinov", 2011)
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Display Library");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayLibrary(library);
                    break;
                case 2:
                    borrowBook(library, scanner);
                    break;
                case 3:
                    returnBook(library, scanner);
                    break;
                case 4:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


class Book{
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = null;
    }

public String getDetails() {
    if (borrowerName != null) {
        return String.format("Title: %s, Author: %s, Year: %d, Borrower: %s", getTitle(), getAuthor(), getYearPublished(), borrowerName);
    } else {
        return String.format("Title: %s, Author: %s, Year: %d, Available", getTitle(), getAuthor(), getYearPublished());
    }
}

    public void updateBookInfo(String newTitle, String newAuthor, int newYearPublished) {
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublished;
    }

    public void borrowBook(String borrowerName) {
        if (this.borrowerName == null) {
            this.borrowerName = borrowerName;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("The book is already borrowed by " + this.borrowerName);
        }
    }

    public void returnBook() {
        if (this.borrowerName != null) {
            this.borrowerName = null;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("The book isn't borrowed.");
        }
    }

    public String getBorrowerName() {
        return this.borrowerName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }
}
