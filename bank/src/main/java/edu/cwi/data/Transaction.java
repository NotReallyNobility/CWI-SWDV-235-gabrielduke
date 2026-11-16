package edu.cwi.data;

import java.math.BigDecimal;
import java.util.Date;

import edu.cwi.data.enums.TransactionTypes;

public class Transaction {
    private int id;
    private int accountId;
    private TransactionTypes transactionType;
    private BigDecimal amount;
    private String description;
    private Date createdAt;
    

    public Transaction() {
        this.createdAt = new Date();
    }

    public Transaction(int id, int accountId, TransactionTypes transactionTypes, BigDecimal amount, String description, Date createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.transactionType = transactionTypes;
        this.amount = amount;
        this.description = description;
        this.createdAt = createdAt;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
