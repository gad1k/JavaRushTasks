package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream(args[1]);
        FileOutputStream fileOut = new FileOutputStream(args[2]);
        switch (args[0]) {
            case "-e":
                while(fileIn.available() > 0) {
                    int data = fileIn.read();
                    fileOut.write(data + 1);
                }
                break;
            case "-d":
                while (fileIn.available() > 0) {
                    int data = fileIn.read();
                    fileOut.write(data - 1);
                }
                break;
        }
        fileOut.close();
        fileIn.close();
    }
}