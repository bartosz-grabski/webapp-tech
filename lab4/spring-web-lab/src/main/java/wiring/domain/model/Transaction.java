package wiring.domain.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Transaction {

	private final Account account;
	private final BigDecimal amount;
	private final DateTime transactionDate;

	public Transaction(Account account, DateTime dateTime, BigDecimal amount) {
		this.account = account;
		this.transactionDate = dateTime;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("Transaction [account=%s, amount=%s, transactionDate=%s]", account, amount,
				transactionDate);
	}

	public Account account() {
		return account;
	}

	public BigDecimal amount() {
		return amount;
	}

    public DateTime transactionDate() {
        return transactionDate;
    }
}
