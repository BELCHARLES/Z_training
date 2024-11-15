package com.stringtaskexception;

public class StringTaskException extends Exception {
    public  StringTaskException(String message) {
        super(message);
    }

    public  StringTaskException(String message,Throwable cause) {
        super(message,cause);
    }

    public StringTaskException (Throwable cause){
        super(cause);
    }
}
