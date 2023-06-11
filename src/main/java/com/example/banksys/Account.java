package com.example.banksys;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private static int accountNo = 0;

    private int accountID;
    private String name;
    private String pass;
    private double balance;
    private String accountType;

    private char gender;

    private String address;

    private LocalDate birth;
    private ArrayList<Bill> accountBills;
    private ArrayList<Transaction> accountTransactions;

    public Account(String name, String pass,String type, String address, LocalDate birth, char gender) throws InvalidPass {

        accountNo++;
        accountID = accountNo;
        this.name = name;
        this.pass = pass;
        if (pass.length() < 6)
            throw new InvalidPass();
        this.balance = 1000;
        accountType = type;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
        this.accountTransactions = new ArrayList<>();
        this.accountBills = new ArrayList<>();
    }


    public static int getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double withdraw) throws InsufficientBalance,InvalidTransaction {
        if(withdraw == 0){
            throw new InvalidTransaction("Amount can't be zero");
        }
        if (withdraw <= balance)
        {
            balance = balance-withdraw;
        }
        else {
            throw new InsufficientBalance(withdraw-balance);
        }
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void deposit(double amount)
    {
        balance+= amount;
    }

    public ArrayList<Transaction> getTransactions() {
        return accountTransactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.accountTransactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        accountTransactions.add(transaction);
    }

    public void addBills(Bill bill) {
        accountBills.add(bill);
    }

    public ArrayList<Bill> getBills() {
        return accountBills;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirth() {
        return birth;
    }
}
