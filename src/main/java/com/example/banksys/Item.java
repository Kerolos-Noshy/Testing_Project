package com.example.banksys;
public class Item {
    private static int itemCounter = 0;
    private String name;
    private double price;

    private int itemID;

    public Item(String name, double price) {
        itemID = ++itemCounter;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public static int getItemCounter() {
        return itemCounter;
    }
}
