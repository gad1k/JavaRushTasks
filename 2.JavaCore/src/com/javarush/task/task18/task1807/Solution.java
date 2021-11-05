package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileName = new FileInputStream(scanner.nextLine());
        int count = 0;
        while (fileName.available() > 0)
            if (fileName.read() == 44)
                count++;
        System.out.println(count);
        fileName.close();
        scanner.close();
    }
}