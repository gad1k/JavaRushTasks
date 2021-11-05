package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileName = new FileInputStream(scanner.nextLine());
        int var, min = Integer.MAX_VALUE;
        while (fileName.available() > 0) {
            var = fileName.read();
            if (var < min)
                min = var;
        }
        System.out.println(min);
        fileName.close();
        scanner.close();
    }
}