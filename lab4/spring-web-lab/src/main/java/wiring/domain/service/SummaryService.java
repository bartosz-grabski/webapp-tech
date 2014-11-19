package wiring.domain.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map.Entry;

import wiring.domain.model.Account;
import wiring.domain.model.Transaction;
import wiring.domain.model.TransactionSummary;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * Implements non-trivial domain logic ;)
 */
public class SummaryService {

	public Collection<TransactionSummary> summarize(Collection<Transaction> transactions) {

		final Multimap<Account, Transaction> byAccount = Multimaps.<Account, Transaction> index(transactions,
				new Function<Transaction, Account>() {
					@Override
					public Account apply(Transaction tx) {
						return tx.account();
					}
				});

		final FluentIterable<TransactionSummary> summaries = FluentIterable.from(byAccount.asMap().entrySet())
				.transform(new TracationSummaryExtractor());

		return summaries.toList();
	}

	private final static class TracationSummaryExtractor implements Function<Entry<Account, Collection<Transaction>>, TransactionSummary> {
		@Override
		public TransactionSummary apply(Entry<Account, Collection<Transaction>> input) {
			return new TransactionSummary(input.getKey(), sum(input.getValue()));
		}

		private static BigDecimal sum(Collection<Transaction> collection) {
			BigDecimal sum = BigDecimal.ZERO;
			for (Transaction item : collection) {
				sum = sum.add(item.amount());
			}
			return sum;
		}
	}

}
