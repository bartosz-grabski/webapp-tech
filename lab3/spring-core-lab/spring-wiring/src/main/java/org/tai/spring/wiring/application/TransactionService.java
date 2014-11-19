package org.tai.spring.wiring.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tai.spring.wiring.domain.model.Transaction;
import org.tai.spring.wiring.domain.model.TransactionSummary;
import org.tai.spring.wiring.domain.repository.TransactionRepository;
import org.tai.spring.wiring.domain.service.SummaryService;

@Service
public class TransactionService {
	
	private final TransactionRepository repository;
	private final SummaryService service;
	
	@Autowired
	public TransactionService(TransactionRepository repository, SummaryService service) {
		this.repository = repository;
		this.service = service;
	}


	public Collection<TransactionSummary> createTrancationSummary(){
		final Collection<Transaction> transations = repository.transations();
		return service.summarize(transations);
	}
	

}
