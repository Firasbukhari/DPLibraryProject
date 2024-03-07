/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dplibraryproject;

/**
 *
 * @author Xxfir
 */
import java.time.LocalDate;

public class Loan {
    public Member member;
    public Book book;
    public LocalDate dueDate;

    public Loan(Member member, Book book, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.dueDate = dueDate;
    }

    // Getters and setters
}