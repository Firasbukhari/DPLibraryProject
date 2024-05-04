package dplibraryproject;

import java.time.LocalDate;
import java.util.Scanner;

public class DPLibraryProject {

    public static void main(String[] args) {
        LibraryFacade facade = new LibraryFacade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library System!");

        while (true) {
            facade.displayOptions(); // Display the options

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    facade.addBook(scanner);
                    break;
                case 2:
                    facade.registerMember(scanner);
                    break;
                case 3:
                    facade.checkOutBook(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class LibraryFacade {
    private Library library;
    private Librarian librarian;

    public LibraryFacade() {
        library = Library.getInstance();
        librarian = new Librarian("Default Librarian", library);
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book.BookBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setIsbn(isbn)
                .build();
        library.getCatalog().addBook(book);
        System.out.println("'" + title + "' added to the catalog.");
    }

    public void registerMember(Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Member member = new Member(name, memberId);
        library.addMember(member);
        System.out.println(name + " registered as a library member.");
    }

    public void checkOutBook(Scanner scanner) {
        System.out.print("Enter member ID for checkout: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Member borrowingMember = null;
        for (Member m : library.getMembers()) {
            if (m.getMemberId() == id) {
                borrowingMember = m;
                break;
            }
        }
        if (borrowingMember == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter ISBN of the book to check out: ");
        String checkoutIsbn = scanner.nextLine();

        Book bookToCheckout = library.getCatalog().findBookByISBN(checkoutIsbn);
        if (bookToCheckout == null) {
            System.out.println("Book not found.");
            return;
        }

        Loan loan = new Loan(borrowingMember, bookToCheckout, LocalDate.now().plusWeeks(2));
        borrowingMember.addLoan(loan);
        System.out.println("Book '" + bookToCheckout.getTitle() + "' checked out to " + borrowingMember.getName() + ".");
    }

    public void displayOptions() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add a Book");
        System.out.println("2. Register a Member");
        System.out.println("3. Check Out a Book");
        System.out.println("4. Exit");
    }
}
