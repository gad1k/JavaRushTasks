package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        int key;
        while (fileIn.available() > 0) {
            key = fileIn.read();
            if (map.containsKey((char) key))
                map.put((char) key, map.get((char) key) + 1);
            else
                map.put((char) key, 1);
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        fileIn.close();
    }
}