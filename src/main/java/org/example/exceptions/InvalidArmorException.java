package org.example.exceptions;

public class InvalidArmorException extends Exception{

    public InvalidArmorException(String errorMessage){
        super(errorMessage);
    }
}
