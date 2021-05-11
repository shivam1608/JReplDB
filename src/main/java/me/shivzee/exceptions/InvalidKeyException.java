package me.shivzee.exceptions;

public class InvalidKeyException extends Exception {
    public InvalidKeyException(String errorMessage){
        super(errorMessage);
    }
}
