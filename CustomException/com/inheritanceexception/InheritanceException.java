package com.inheritanceexception;

public class InheritanceException extends Exception {
    public  InheritanceException(String message) {
        super(message);
    }

    public  InheritanceException(String message,Throwable cause) {
        super(message,cause);
    }

    public InheritanceException (Throwable cause){
        super(cause);
    }
}
