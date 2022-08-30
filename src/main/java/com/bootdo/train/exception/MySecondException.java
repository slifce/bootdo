package com.bootdo.train.exception;

public class MySecondException extends Throwable {

    public MySecondException() {

    }

    public MySecondException(String msg) {
        super(msg);
    }

    public MySecondException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MySecondException(Throwable cause) {
        super(cause);
    }
}
