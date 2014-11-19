package org.tai.web.servlet.user.transaction;

import java.math.BigDecimal;

/**
 * @author Przemyslaw Dadel
 */
public class NewUserTransaction {

    private String accountNumber;
    private BigDecimal transactionValue;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }
}
