/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dplibraryproject;

/**
 *
 * @author Xxfir
 */
public class Librarian implements Cloneable {
    public String name;
    public Library library;

    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    // Librarian actions (manage books, members, etc.)
    
    // Override the clone method to create a deep copy of the Librarian object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Librarian clonedLibrarian = (Librarian) super.clone();
        // Perform deep copy of the Library object
        clonedLibrarian.library = (Library) this.library.clone();
        return clonedLibrarian;
    }
}
