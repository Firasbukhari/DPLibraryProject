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
        Scanner scanner = new Scanner(System.in);
    
        // Create a prototype instance of the Library
        Library libraryPrototype = Library.getInstance();
    
        // Create a prototype instance of the Librarian
        Librarian librarianPrototype = new Librarian("Default Librarian", libraryPrototype);
    
        System.out.println("Welcome to the Library System!");
    
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. Register a Member");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Exit");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1 -> {
                    // Add a book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
    
                    try {
                        // Clone the prototype Library instance
                        Library library = (Library) libraryPrototype.clone();
                        Book book = new Book(title, author, isbn);
                        library.getCatalog().addBook(book);
                        System.out.println("'" + title + "' added to the catalog.");
                    } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    // Register a member
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
    
                    try {
                        // Clone the prototype Librarian instance
                        Librarian librarian = (Librarian) librarianPrototype.clone();
                        Member member = new Member(name, memberId);
                        librarian.library.addMember(member);
                        System.out.println(name + " registered as a library member.");
                    } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 -> {
                    // Check out a book
                    System.out.print("Enter member ID for checkout: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
    
                    // Find the borrowing member
                    Member borrowingMember = null;
                    for (Member m : libraryPrototype.getMembers()) {
                        if (m.getMemberId() == id) {
                            borrowingMember = m;
                            break;
                        }
                    }
                    if (borrowingMember == null) {
                        System.out.println("Member not found.");
                        break;
                    }
    
                    System.out.print("Enter ISBN of the book to check out: ");
                    String checkoutIsbn = scanner.nextLine();
    
                    try {
                        // Clone the prototype Library instance
                        Library library = (Library) libraryPrototype.clone();
                        Book bookToCheckout = library.getCatalog().findBookByISBN(checkoutIsbn);
                        if (bookToCheckout == null) {
                            System.out.println("Book not found.");
                            break;
                        }
    
                        // Create a new Loan instance
                        Loan loan = new Loan(borrowingMember, bookToCheckout, LocalDate.now().plusWeeks(2));
                        borrowingMember.addLoan(loan);
                        System.out.println("Book '" + bookToCheckout.getTitle() + "' checked out to " + borrowingMember.getName() + ".");
                    } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 -> {
                    // Exit
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}