package com.bootdo.train.exception;

public class App1MyException {

    public static void firstException() throws MyFirstException {
        throw new MyFirstException("firstException() method occurs an exception!");
    }

    public static void secondException() throws MySecondException {
        throw new MySecondException("secondException() method occurs an exception!");
    }

    public static void main(String[] args) {
        try {
            App1MyException.firstException();
            App1MyException.secondException();
        } catch (MyFirstException e1) {
            System.out.println("Exception:" + e1.getMessage());
            e1.printStackTrace();
        } catch (MySecondException e2) {
            System.out.println("Exception:" + e2.getMessage());
            e2.printStackTrace();
        }
    }
}
