import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(String filename, BankStatementParser parser) throws IOException {
        Path path = Paths.get(RESOURCES + filename);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> transactions = parser.parseLines(lines);
        BankStatementProcessor processor = new BankStatementProcessor(transactions);


        collectSummary(processor);
    }

    public static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("Total = " + bankStatementProcessor.calculateTotal());
        System.out.println("January Total = " + bankStatementProcessor.calculateTotalForMonth(Month.JANUARY));
        System.out.println("February Total = " + bankStatementProcessor.calculateTotalForMonth(Month.FEBRUARY));
        System.out.println("Total salary received is " + bankStatementProcessor.calculateForCategory("Salary"));

        System.out.println("Max Transaction is " + bankStatementProcessor.calculateMaxTransaction(Month.JANUARY));
        System.out.println("Min Transaction is " + bankStatementProcessor.calculateMinTransaction(Month.FEBRUARY));
        System.out.println("Month's transactions: " + bankStatementProcessor.GroupByMonthOrByDescription(Month.FEBRUARY, "Salary"));
    }
}
