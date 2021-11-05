package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<String, Double>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str, name;
        double value, max = Double.MIN_VALUE;
        while ((str = reader.readLine()) != null) {
            name = str.split(" ")[0];
            value = Double.parseDouble(str.split(" ")[1]);
            if (map.containsKey(name))
                map.put(name, map.get(name) + value);
            else
                map.put(name, value);
        }
        max = Collections.max(map.values());
        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue() == max)
                System.out.println(pair.getKey());
        reader.close();
    }
}