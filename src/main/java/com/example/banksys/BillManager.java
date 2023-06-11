package com.example.banksys;

public class BillManager {

    private static BillManager instance;

    private int billID;

    private BillManager(){}

    public static BillManager getInstance(){
        if(instance == null)
            instance = new BillManager();
        return instance;
    }

    public int getBillID(){
        return  billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }
}
