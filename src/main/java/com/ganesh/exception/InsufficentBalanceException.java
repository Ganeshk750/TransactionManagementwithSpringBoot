package com.ganesh.exception;

public class InsufficentBalanceException extends Exception{

    public InsufficentBalanceException(String errorMsg){
        super(errorMsg);
    }
}
