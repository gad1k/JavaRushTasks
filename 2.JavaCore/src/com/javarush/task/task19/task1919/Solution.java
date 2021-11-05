package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<String, Double>();
        Scanner scanner = new Scanner(new FileReader(args[0]));
        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            if (map.containsKey(str.split(" ")[0]))
                map.put(str.split(" ")[0], map.get(str.split(" ")[0]) + Double.parseDouble(str.split(" ")[1]));
            else
                map.put(str.split(" ")[0], Double.parseDouble(str.split(" ")[1]));
        }
        for (Map.Entry<String, Double> pair : map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        scanner.close();
    }
}