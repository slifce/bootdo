package com.bootdo.train.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 一个顺序读取文本文件的例子
 */
public class App2Read {

    public static void main(String[] args) {
        FileInputStream fis;
        try {
            fis = new FileInputStream("D:\\WorkSpaces\\05_Idea\\bootdo\\src\\main\\resources\\generator-copy.properties");
            System.out.println("content of text is : ");
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
