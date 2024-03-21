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
    private static Library instance = null; // Singleton instance
    private Catalog catalog;
    private List<Member> members;

    private Library() { // Private constructor
        this.catalog = new Catalog();
        this.members = new ArrayList<>();
    }

    public static Library getInstance() {  // Singleton accessor 
        if (instance == null) {  // Create the instance if it doesn't exist
            instance = new Library();
        }
        return instance;
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