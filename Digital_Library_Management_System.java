import java.util.ArrayList;
import java.util.Scanner;

public class Digital_Library_Management_System {
    private ArrayList<Book> books;

    public Digital_Library_Management_System() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            System.out.println("Books in library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Digital_Library_Management_System library = new Digital_Library_Management_System();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Library Management System!");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Display books");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.next();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    library.displayBooks();
                    System.out.print("Enter book index to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < library.books.size()) {
                        Book bookToRemove = library.books.get(index);
                        library.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Invalid book index.");
                    }
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return title + " by " + author + ", ISBN: " + isbn;
    }
}
