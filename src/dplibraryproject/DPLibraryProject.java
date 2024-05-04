/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dplibraryproject;

/**
 *
 * @author Xxfir
 */

import java.time.LocalDate;
import java.util.Scanner;

public class DPLibraryProject {

    public static void main(String[] args) {

        LibraryFacade facade = new LibraryFacade();  // Facade object
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
        
        class LibraryFacade {    // Facade class to interact with the library system
            private Library library;
            private Librarian librarian;
        
            public LibraryFacade() {   // Constructor
                library = Library.getInstance();
                librarian = new Librarian("Default Librarian", library);
            }
        
            public void addBook(Scanner scanner) {  // Add a book to the library catalog
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
        
                try {
                    Library clonedLibrary = (Library) library.clone();
                    Book book = new Book(title, author, isbn);
                    clonedLibrary.getCatalog().addBook(book);
                    System.out.println("'" + title + "' added to the catalog.");
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
            }
        
            public void registerMember(Scanner scanner) {   // Register a new member
                System.out.print("Enter member name: ");
                String name = scanner.nextLine();
                System.out.print("Enter member ID: ");
                int memberId = scanner.nextInt();
        
                try {
                    Librarian clonedLibrarian = (Librarian) librarian.clone();
                    Member member = new Member(name, memberId);
                    clonedLibrarian.library.addMember(member);
                    System.out.println(name + " registered as a library member.");
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
            }
        
            public void checkOutBook(Scanner scanner) {         // Check out a book
                System.out.print("Enter member ID for checkout: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
        
                Member borrowingMember = null;
                for (Member m : library.getMembers()) {  // Find the member by ID
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
        
                try {
                    Library clonedLibrary = (Library) library.clone();
                    Book bookToCheckout = clonedLibrary.getCatalog().findBookByISBN(checkoutIsbn);
                    if (bookToCheckout == null) {
                        System.out.println("Book not found.");
                        return;
                    }
        
                    Loan loan = new Loan(borrowingMember, bookToCheckout, LocalDate.now().plusWeeks(2)); 
                    borrowingMember.addLoan(loan);
                    System.out.println("Book '" + bookToCheckout.getTitle() + "' checked out to " + borrowingMember.getName() + ".");
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
            }
        
            public void displayOptions() {
                System.out.println("\nPlease choose an option:");
                System.out.println("1. Add a Book");
                System.out.println("2. Register a Member");
                System.out.println("3. Check Out a Book");
                System.out.println("4. Exit");
            }
        }