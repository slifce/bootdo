package com.bootdo.train.exception;

public class MyFirstException extends Exception {

    public MyFirstException() {
        super();
    }

    public MyFirstException(String msg) {
        super(msg);
    }

    public MyFirstException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyFirstException(Throwable cause) {
        super(cause);
    }
}
