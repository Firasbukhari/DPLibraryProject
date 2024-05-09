package dplibraryproject;
/**
 *
 * @author Abdullah Abdulbari 2142536
 */
import java.time.LocalDate;

public class PriorityLoanStrategy implements LoanStrategy {
    @Override
    public void processLoan(Member member, Book book) {
        Loan loan = new Loan(member, book, LocalDate.now().plusDays(10)); // Shorter loan period for priority loans
        member.addLoan(loan);
        System.out.println("Book '" + book.getTitle() + "' with priority checked out to " + member.getName() + ".");
    }
}
