package wiring.domain.repository;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import wiring.domain.model.Account;
import wiring.domain.model.Transaction;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

public class TransactionRepository {

    private final JdbcTemplate template;

    public TransactionRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Collection<Transaction> transactions() {
        return template.query("select accountNumber, date, amount from transactions", new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                final String accountNumber = rs.getString("accountNumber");
                final Timestamp timestamp = rs.getTimestamp("date");
                final BigDecimal amount = rs.getBigDecimal("amount");
                return new Transaction(Account.of(accountNumber), new DateTime(timestamp), amount);
            }
        });

    }

    public Collection<Transaction> transactions(final Account account) {
        return template.query("select date, amount from transactions where accountNumber = ?", new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                final Timestamp timestamp = rs.getTimestamp("date");
                final BigDecimal amount = rs.getBigDecimal("amount");
                return new Transaction(account, new DateTime(timestamp), amount);
            }
        }, account.number());

    }

    public void save(Transaction transaction) {
        template.update("insert into transactions(accountNumber, date, amount) values (?, ? ,?)", transaction.account().number(), transaction.transactionDate().toDate(), transaction.amount());
    }
}
