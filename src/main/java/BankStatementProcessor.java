import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotal() {
        double total = 0d;
        for (BankTransaction transaction : bankTransactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public double calculateTotalForMonth(Month month) {
        double total = 0d;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth() == month) {
                total += transaction.getAmount();
            }

        }
        return total;
    }

    public double calculateForCategory(String category) {
        double total = 0d;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDescription().equals(category)) {
                total += transaction.getAmount();
            }

        }
        return total;
    }

    public double calculateMaxTransaction(LocalDate dateInitial, LocalDate dateFinal) {
        double max = 0d;

        if (dateInitial.isBefore(dateFinal)) {
            for (BankTransaction transaction : bankTransactions) {
                if (transaction.getAmount() > max) {
                    max = transaction.getAmount();
                }
            }
        }
        return max;
    };

    public double calculateMinTransaction(LocalDate dateInitial, LocalDate dateFinal) {
        double min = 0d;

        if (dateInitial.isBefore(dateFinal)) {
            for (BankTransaction transaction : bankTransactions) {
                if (transaction.getAmount() < min) {
                    min = transaction.getAmount();
                }
            }
        }
        return min;
    }

    public double GroupByMonthOrByDescription(Month month) {

        for (BankTransaction transaction : bankTransactions) {
            if ((transaction.getDate().getMonth() == month)) {
                System.out.println(transaction);
            }
        }
        return(bankTransactions.size() - 2);
    }
}
