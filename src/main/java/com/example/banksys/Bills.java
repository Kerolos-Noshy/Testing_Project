package com.example.banksys;

import java.time.LocalDate;

public class Bills {
    LocalDate date;
    String store;
    Double price;
    Integer billid;


    public Bills(Integer billid, LocalDate date, String store, Double price) {
        this.billid = billid;
        this.date = date;
        this.store = store;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStore(){
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }
}
