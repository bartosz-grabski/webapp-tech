package org.tai.spring.wiring.domain.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.tai.spring.wiring.domain.model.Account;
import org.tai.spring.wiring.domain.model.Transaction;

@Repository
public class TransactionRepository {

	
	private final JdbcTemplate template;

	@Autowired
	public TransactionRepository(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public Collection<Transaction> transations() {
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

}
