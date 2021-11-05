package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileName = new FileInputStream(scanner.nextLine());
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int key, max = Integer.MIN_VALUE;
        while (fileName.available() > 0) {
            key = fileName.read();
            if (countMap.containsKey(key))
                countMap.put(key, countMap.get(key) + 1);
            else
                countMap.put(key, 1);
        }
        for (Map.Entry<Integer, Integer> pair : countMap.entrySet())
            if (pair.getValue() > max)
                max = pair.getValue();
        for (Map.Entry<Integer, Integer> pair : countMap.entrySet())
            if (pair.getValue() == max)
                System.out.print(pair.getKey() + " ");
        fileName.close();
        scanner.close();
    }
}