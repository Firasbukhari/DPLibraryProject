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
            System.out.print("Select Loan Strategy: 1 for Normal, 2 for Priority");
            int strategyChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (strategyChoice == 2) {
                facade.setLoanStrategy(new PriorityLoanStrategy());
            } else {
                facade.setLoanStrategy(new NormalLoanStrategy());
            }
        
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Command command;
        
            switch (choice) {
                case 1:
                    command = new AddBookCommand(facade, scanner);
                    break;
                case 2:
                    command = new RegisterMemberCommand(facade, scanner);
                    break;
                case 3:
                    command = new CheckOutBookCommand(facade, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }
            command.execute();
        }
    }
}

class LibraryFacade {
    private Library library;
    private Librarian librarian;
    private LoanStrategy loanStrategy;  // Field to hold the current loan strategy

    public LibraryFacade() {
        library = Library.getInstance();
        librarian = new Librarian("Default Librarian", library);
        this.loanStrategy = new NormalLoanStrategy();  // Default strategy
    }

    // Method to set the current loan strategy
    public void setLoanStrategy(LoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
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

        // Use the current loan strategy to process the loan
        loanStrategy.processLoan(borrowingMember, bookToCheckout);
    }

    public void displayOptions() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add a Book");
        System.out.println("2. Register a Member");
        System.out.println("3. Check Out a Book");
        System.out.println("4. Exit");
    }
}