package org.tai.web.servlet.rest.report;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wiring.application.TransactionService;
import wiring.domain.model.TransactionSummary;

/**
 * @author Przemyslaw Dadel
 */
@Controller
@RequestMapping("/transactions")
public class RestReportController {

	private final TransactionService transactionService;

	@Autowired
    public RestReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value="/summary")
    public @ResponseBody Collection<TransactionSummary> summary() {
        return transactionService.createTransactionSummary();
    }

}
