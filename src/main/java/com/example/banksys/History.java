package com.example.banksys;

import java.time.LocalDate;

public class History {
     private int id;
     private LocalDate date;
    private Double amount;
    private String details;

    public History(int id, LocalDate date, String details, double amount) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.details = details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDetails() {
        return details;
    }
}
