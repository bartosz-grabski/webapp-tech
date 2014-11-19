package org.tai.spring.wiring.domain.model;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionSummary {

	private final Account account;
	private final BigDecimal totalTransactionAmount;

	public TransactionSummary(Account account, BigDecimal totalTransactionAmount) {
		this.account = requireNonNull(account);
		this.totalTransactionAmount = requireNonNull(totalTransactionAmount);
	}

	public Account account() {
		return account;
	}

	public BigDecimal totalTransactionAmount() {
		return totalTransactionAmount;
	}

	@Override
	public String toString() {
		return String.format("TransactionSummary [account=%s, totalTransactionAmount=%s]", account,
				totalTransactionAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final TransactionSummary other = (TransactionSummary) obj;
		return Objects.equals(this.account, other.account) && Objects.equals(this.totalTransactionAmount, other.totalTransactionAmount);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(account, totalTransactionAmount);
	}


	

}
