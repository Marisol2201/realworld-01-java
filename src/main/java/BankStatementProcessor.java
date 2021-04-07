import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
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

    public double calculateMaxTransaction(Month month) {
        double max = -100000;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth().equals(month)) {
                if (transaction.getAmount() > max) {
                    max = transaction.getAmount();
                }
            }
        }
        return max;
    }

    public double calculateMinTransaction(Month month) {
        double min = 100000;
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth().equals(month)) {
                if (transaction.getAmount() < min) {
                    min = transaction.getAmount();
                }
            }
        }
        return min;
    }

    public List<BankTransaction> GroupByMonthOrByDescription(Month month, String description) {
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth().equals(month) && transaction.getDescription().equals(description)) {
                result.add(transaction);
            }
        }
        return result;
    }
}
