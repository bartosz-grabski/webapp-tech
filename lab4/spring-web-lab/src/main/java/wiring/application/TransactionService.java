package wiring.application;

import wiring.domain.model.Transaction;
import wiring.domain.model.TransactionSummary;
import wiring.domain.repository.TransactionRepository;
import wiring.domain.service.SummaryService;

import java.util.Collection;

public class TransactionService {

    private final TransactionRepository repository;
    private final SummaryService service;

    public TransactionService(TransactionRepository repository, SummaryService service) {
        this.repository = repository;
        this.service = service;
    }

    public Collection<TransactionSummary> createTransactionSummary() {
        final Collection<Transaction> transactions = repository.transactions();
        return service.summarize(transactions);
    }

    public Collection<Transaction> listTransactions() {
        return repository.transactions();
    }

    public void enlistTransaction(Transaction transaction) {
        repository.save(transaction);
    }


}
