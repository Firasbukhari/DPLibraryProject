package dplibraryproject;
/**
 *
 * @author Abdullah Abdulbari 2142536
 */
import java.util.Scanner;

public class AddBookCommand implements Command {
    private LibraryFacade libraryFacade;
    private Scanner scanner;

    public AddBookCommand(LibraryFacade libraryFacade, Scanner scanner) {
        this.libraryFacade = libraryFacade;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        libraryFacade.addBook(scanner);
    }
}
