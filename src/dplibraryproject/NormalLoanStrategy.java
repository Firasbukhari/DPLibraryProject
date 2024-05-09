package dplibraryproject;
/**
 *
 * @author Abdullah Abdulbari 2142536
 */
import java.time.LocalDate;

public class NormalLoanStrategy implements LoanStrategy {
    @Override
    public void processLoan(Member member, Book book) {
        Loan loan = new Loan(member, book, LocalDate.now().plusWeeks(2));
        member.addLoan(loan);
        System.out.println("Book '" + book.getTitle() + "' normally checked out to " + member.getName() + ".");
    }
}
