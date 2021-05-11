package me.shivzee.exceptions;

public class InvalidDBUrlException extends Exception{
    public InvalidDBUrlException(String errorMessage){
        super(errorMessage);
    }
}
