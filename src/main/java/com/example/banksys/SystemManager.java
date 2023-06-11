package com.example.banksys;

import java.time.LocalDate;
import java.util.ArrayList;

public class SystemManager {
    private static SystemManager instance = null;
    private static ArrayList<Account> accounts = new ArrayList<>();

    private static ArrayList<Item> items = new ArrayList<>();
    private static int storeID;

    private int currentUserID;

    private static Bill bill;
    private SystemManager(){

    }
    public static void initialize() throws InvalidPass{

        var a1 = new Account("Yehia", "123456", "Checking",
                "Dummy Address 1",LocalDate.of(2002,10,22), 'M');

        var a2 = new Account("Noha", "123456", "Saving",
                "Dummy Address 2", LocalDate.of(2002,5,12), 'F');

        var a3 = new Account("Kero", "123456", "Checking",
                "Dummy Address 3",LocalDate.of(2002,8,2), 'M');

        var a4 = new Account("Store X", "123456", "Checking",
                "Dummy Address 3", LocalDate.of(2023, 6, 7), 'M');
        storeID = a4.getAccountID();
        bill = new Bill(storeID);
        items.add(new Item("TShirt",200));
        items.add(new Item("Shoes",100));
        items.add(new Item("Football",50));
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
    }
    public static SystemManager getInstance(){
        if(instance == null)
            instance = new SystemManager();
        return instance;
    }

    public Account getAccountById(int accountID) {
        for(Account account : accounts)
            if (account.getAccountID() == accountID)
                return account;
        return null;
    }

    public boolean match(String name, String pass){
        for(Account account : accounts)
            if (account.getName().equals(name) && account.getPass().equals(pass)) {
                currentUserID = account.getAccountID();
                return true;
            }
        return false;

    }
    public Account getLoggedInUser() {
        for(Account account : accounts)
            if (account.getAccountID() == currentUserID)
                return account;
        return null;
    }

    public void logOut(){
        currentUserID = -1;
    }

    public void addAccount(String name, String pass,String type, String address, LocalDate birth, char gender) throws InvalidPass{
        Account acc = new Account(name, pass, type, address, birth, gender);
        accounts.add(acc);
        currentUserID = acc.getAccountID();
    }

    public Item[] getItems(){
        Item[] itemArray = new Item[items.size()];
        for(int i = 0 ; i < items.size() ; i++){
            itemArray[i] = items.get(i);
        }
        return itemArray;
    }
    public int getStoreID() {
        return storeID;
    }


    public Bill getBill(){
        return bill;
    }

    public void resetBill(){
        bill = new Bill(storeID);
    }

    public int getAccountsNo(){return accounts.size();}

    public int getItemsNo(){return items.size();}

}
