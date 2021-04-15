package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        String id, name;
        while (true) {
            id = reader.readLine();
            if (id.isEmpty())
                break;
            name = reader.readLine();
            if (name.isEmpty())
                break;
            map.put(name, id);
        }
        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.println(pair.getValue() + ' ' + pair.getKey());
    }
}