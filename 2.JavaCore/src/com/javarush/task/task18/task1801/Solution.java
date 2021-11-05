package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileName = new FileInputStream(scanner.nextLine());
        int var, max = Integer.MIN_VALUE;
        while (fileName.available() > 0) {
            var = fileName.read();
            if (var > max)
                max = var;
        }
        System.out.println(max);
        fileName.close();
        scanner.close();
    }
}