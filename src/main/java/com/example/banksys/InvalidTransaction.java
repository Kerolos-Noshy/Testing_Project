package com.example.banksys;

public class InvalidTransaction extends Exception{
    public  InvalidTransaction(String msg){
        super(msg);
    }
}
