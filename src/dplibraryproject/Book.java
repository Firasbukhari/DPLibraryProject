/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dplibraryproject;

/**
 *
 * @author Xxfir
 */
public class Book {
    public String title;
    public String author;
    public String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getter for ISBN
    public String getIsbn() {
        return isbn;
    }

    // Consider adding getters for title and author as well
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Optionally, you can also add setters if you need to modify these fields after object creation
}