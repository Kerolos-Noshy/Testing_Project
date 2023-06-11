package com.example.banksys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bill {
    private static int bills = 0;
    private int billID;
    private LocalDate date;
    private int storeID;

    private Map<Item, Integer> itemQuantities;

    public Bill(int accountID) {
        this.billID = ++bills;
        this.date = LocalDate.now();
        this.storeID = accountID;
        this.itemQuantities = new HashMap<>();
    }

    public void buyItem(Item item, int quantity) {
        boolean found = false;
        for (Map.Entry<Item, Integer> entry : itemQuantities.entrySet()) {
            Item item1 = entry.getKey();
            if (item1.getItemID() == item.getItemID()){
                entry.setValue(entry.getValue() + quantity);
                found = true;
                break;
            }
        }
        if(!found)
            itemQuantities.put(item, quantity);
    }

    public boolean isItemExist(Item item){
        boolean found = false;
        for (Map.Entry<Item, Integer> entry : itemQuantities.entrySet()){
            Item item1 = entry.getKey();
            if(item.getItemID() == item1.getItemID()){
                found = true;
                break;
            }
        }
        return found;
    }

    public double calculatePrice() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : itemQuantities.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }

    public int getBillID() {
        return billID;
    }

    public Map<Item, Integer> getItemQuantities() {
        return itemQuantities;
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : itemQuantities.entrySet()) {
            items.add(entry.getKey());
        }
        return items;
    }

    public void removeItem(Item item) {
        itemQuantities.remove(item);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getStoreID() {
        return storeID;
    }
}


