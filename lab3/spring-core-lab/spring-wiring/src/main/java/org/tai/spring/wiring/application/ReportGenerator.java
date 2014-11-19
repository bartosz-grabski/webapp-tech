package org.tai.spring.wiring.application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tai.spring.wiring.domain.model.TransactionSummary;

import com.google.common.base.Stopwatch;

@Component
public class ReportGenerator {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

	private final TransactionService transactionService;	
	private final String reportLocation;

	@Autowired
	public ReportGenerator(TransactionService transactionService, @Value("${report.location}") String reportLocation) {
		this.transactionService = transactionService;
		this.reportLocation = reportLocation;
		// ensure reportLocation exists
		Paths.get(reportLocation).toFile().mkdirs();
	}

	public void generate() throws IOException {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		final Path reportFile = createFilePath();
		final Collection<TransactionSummary> summaries = transactionService.createTrancationSummary();
		try (BufferedWriter writer = Files.newBufferedWriter(reportFile, Charset.forName("utf-8"), StandardOpenOption.CREATE_NEW)) {
			for (TransactionSummary summary : summaries) {
				writer.write(String.format("%s;%s%n", summary.account(), summary.totalTransactionAmount()));
			}
		}
		LOGGER.info("Succesfully generated report to file {} in {} ms", reportFile,
				stopwatch.elapsed(TimeUnit.MILLISECONDS));
	}

	private Path createFilePath() {
		return Paths.get(reportLocation + '/' + System.currentTimeMillis() + ".txt");
	}
}
