package com.example.banksys;
public class InvalidPass extends Exception{
    public  InvalidPass() {
        super("Not Valid Password");
    }
}
