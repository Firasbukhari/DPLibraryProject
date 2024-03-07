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

public class Library {
    public Catalog catalog;
    public List<Member> members;

    public Library() {
        this.catalog = new Catalog();
        this.members = new ArrayList<>();
    }

    // Methods to manage library (add members, books, etc.)
    // Accessor for the catalog
    public Catalog getCatalog() {
        return this.catalog;
    }

    // Method to add a new member
    public void addMember(Member member) {
        this.members.add(member);
    }
    
    // Method to get the list of all members
    public List<Member> getMembers() {
        return this.members;
    }
    
}