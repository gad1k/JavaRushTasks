package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream pathFile = new FileInputStream(args[0]);
        int cSpace = 0, cAll = 0;
        while (pathFile.available() > 0) {
            cAll++;
            if (pathFile.read() == 32)
                cSpace++;
        }
        System.out.println(String.format("%.2f", (float) cSpace / cAll * 100));
        pathFile.close();
    }
}