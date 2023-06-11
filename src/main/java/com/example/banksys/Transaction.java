package com.example.banksys;
import java.time.LocalDate;

public class Transaction {
    private static int transactions = 0;
    private int transactionId;
    private LocalDate transactionDate;
    private double amount;
    private int fromAccount;
    private int toAccount;

    public Transaction(double amount, int fromAccountId, int toAccountId) throws InvalidTransaction {

        transactionId = ++transactions;
        this.transactionDate = LocalDate.now();
        this.amount = amount;

        this.fromAccount=fromAccountId;
        this.toAccount=toAccountId;
        if (fromAccountId == toAccountId){
            throw new InvalidTransaction("Sender and Receiver can't be the same");
        }
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getFromAccountId() {
        return fromAccount;
    }

    public void setFromAccountId(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccountId() {
        return toAccount;
    }

    public void setToAccountId(int toAccount) {
        this.toAccount = toAccount;
    }

    public void transfer() throws InsufficientBalance, InvalidTransaction {
        SystemManager sys = SystemManager.getInstance();
        Account fromAccountObj = sys.getAccountById(fromAccount);
        Account toAccountObj = sys.getAccountById(toAccount);

        fromAccountObj.withdraw(amount);

        toAccountObj.deposit(amount);
        fromAccountObj.addTransaction(this);
        toAccountObj.addTransaction(this);
    }
}
