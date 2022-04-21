package com.bootdo.train.stream;

import java.io.File;

/**
 * 打印当前目录下面的java文件和文件夹名
 */


public class App1Filter {

    public static void main(String[] args) {
        File file = new File("D:\\WorkSpaces\\05_Idea\\bootdo\\src\\main\\java\\com\\bootdo\\train");
        // 过滤文件
        Filter filter = new Filter("java");
        System.out.println("list java files in directory " + file);
        String[] files = file.list(filter);
        for (int i = 0; i < files.length; i++) {
            File file1 = new File(file, files[i]);
            if (file1.isFile()) {
                System.out.println("file " + file1);
            } else {
                System.out.println("sub directory " + file1);
            }
        }
    }
}
