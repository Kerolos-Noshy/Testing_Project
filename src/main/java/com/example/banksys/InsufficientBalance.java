package com.example.banksys;
public class InsufficientBalance extends Exception{
    public  InsufficientBalance(double required) {
        super("An amount of " + required + " is required");
    }
}

