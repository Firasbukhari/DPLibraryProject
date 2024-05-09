package dplibraryproject;
/**
 *
 * @author Abdullah Abdulbari 2142536
 */
import java.util.Scanner;

public class RegisterMemberCommand implements Command {
    private LibraryFacade libraryFacade;
    private Scanner scanner;

    public RegisterMemberCommand(LibraryFacade libraryFacade, Scanner scanner) {
        this.libraryFacade = libraryFacade;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        libraryFacade.registerMember(scanner);
    }
}
