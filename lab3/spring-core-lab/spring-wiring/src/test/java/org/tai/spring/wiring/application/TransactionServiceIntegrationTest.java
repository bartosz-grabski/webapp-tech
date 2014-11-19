package org.tai.spring.wiring.application;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tai.spring.wiring.application.TransactionService;
import org.tai.spring.wiring.domain.model.Account;
import org.tai.spring.wiring.domain.model.TransactionSummary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:context.xml")
@ActiveProfiles("test")
public class TransactionServiceIntegrationTest {

	@Autowired
	private TransactionService underTest;

	@Test
	public void shouldGroupTrnsactionsByAccounts() {
		// when
		final Collection<TransactionSummary> summaries = underTest.createTrancationSummary();

		Assertions.assertThat(summaries).hasSize(2);
	}

	@Test
	public void shouldSumTransactionsForAccounts() {
		// when
		final Collection<TransactionSummary> summaries = underTest.createTrancationSummary();

		final Collection<TransactionSummary> expected = Arrays.asList(
				new TransactionSummary(Account.of("00000001"), BigDecimal.valueOf(20000, 2)),
				new TransactionSummary(Account.of("99999999"), BigDecimal.valueOf(100, 2)));

		// then
		Assertions.assertThat(summaries).isEqualTo(expected);
	}

}
