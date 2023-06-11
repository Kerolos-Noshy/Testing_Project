package com.example.banksys;

public class Cart {
    String name;
    Integer Qty;
    Double price;

    public Cart(String name, Integer qty, Double price) {
        this.name = name;
        Qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public double getPrice() {
        return price;
    }

}
