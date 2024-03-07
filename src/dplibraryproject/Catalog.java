/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dplibraryproject;

/**
 *
 * @author Xxfir
 */
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Method to find a book by its ISBN
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // If no book found
    }

    // Method to get the list of all books in the catalog
    public List<Book> getBooks() {
        return books;
    }
}