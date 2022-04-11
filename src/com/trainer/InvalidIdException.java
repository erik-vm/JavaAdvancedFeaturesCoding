package com.trainer;

public class InvalidIdException extends Exception{

    public InvalidIdException(String invoiceNumber){
        super("Invoice number " + invoiceNumber + " is too long.");
    }
}
