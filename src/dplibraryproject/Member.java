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

public class Member {
    public String name;
    public int memberId;
    public List<Loan> loans;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.loans = new ArrayList<>();
    }

    // Methods related to members (borrow book, return book, etc.)
    
    // Method to add a loan
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    // Accessor for the member's name
    public String getName() {
        return this.name;
    }
    
    // Method to get the member's ID
    public int getMemberId() {
        return this.memberId;
    }
    
}