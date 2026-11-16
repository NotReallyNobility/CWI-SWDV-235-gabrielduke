package edu.cwi.data;

import java.math.BigDecimal;

import edu.cwi.data.enums.AccountTypes;

public class Account {
    private int id;
    private int userId;
    private AccountTypes accountType;
    private BigDecimal balance;

    public Account() {
        this.accountType = AccountTypes.CHECKING;
    }

    public Account(int id, int userId, AccountTypes accountType, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
