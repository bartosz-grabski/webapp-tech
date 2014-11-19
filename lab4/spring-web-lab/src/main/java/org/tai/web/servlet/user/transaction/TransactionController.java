package org.tai.web.servlet.user.transaction;

import java.util.Collection;

import javax.ws.rs.Path;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import wiring.application.TransactionService;
import wiring.domain.model.Account;
import wiring.domain.model.Transaction;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;


/**
 * @author Przemyslaw Dadel
 */
@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value="/enlist", method=RequestMethod.GET)
    public ModelAndView prepareEnlistNewTransaction() {
        return new ModelAndView("enlist", "command", new NewUserTransaction());
    }

    @RequestMapping(value="/enlist", method=RequestMethod.POST)
    public View enlistNewTransaction(NewUserTransaction newUserTransaction, RedirectAttributes redirectAttributes) {
        final Transaction transaction = createTransaction(newUserTransaction);
        transactionService.enlistTransaction(transaction);

        redirectAttributes.addFlashAttribute("status", "success");

        return new RedirectView("/user/transactions/list", true);
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView listTransactions(ModelAndView modelAndView) {
        modelAndView.addObject("transactions", toUglyObjectsWithGetters(transactionService.listTransactions()));
        modelAndView.setViewName("list");
        return modelAndView;
    }

    private Transaction createTransaction(NewUserTransaction newUserTransaction) {
        return new Transaction(Account.of(newUserTransaction.getAccountNumber()), DateTime.now(), newUserTransaction.getTransactionValue());
    }

    private Collection<UserTransaction> toUglyObjectsWithGetters(Collection<Transaction> transactions) {
        return FluentIterable.from(transactions).transform(new Function<Transaction, UserTransaction>() {
            @Override
            public UserTransaction apply(Transaction input) {
                return new UserTransaction(input.account().number(), input.transactionDate(), input.amount());
            }
        }).toList();
    }

}
