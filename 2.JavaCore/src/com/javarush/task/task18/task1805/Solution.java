package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileName = new FileInputStream(scanner.nextLine());
        List<Integer> list = new ArrayList<Integer>();
        int key;
        while (fileName.available() > 0) {
            key = fileName.read();
            if (!list.contains(key))
                list.add(key);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        fileName.close();
        scanner.close();
    }
}