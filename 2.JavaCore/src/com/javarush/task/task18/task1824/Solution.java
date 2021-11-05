package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<FileInputStream> list = new ArrayList<FileInputStream>();
        String fileName;
        while (true) {
            fileName = scanner.nextLine();
            try {
                list.add(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
        for (FileInputStream entry : list)
            entry.close();
        scanner.close();
    }
}