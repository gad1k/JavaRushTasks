package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready())
            sb.append((char) fileReader.read());
        for (String entry : String.valueOf(sb).split("\\p{Punct}|\\p{Space}")) {
            if (entry.trim().equals("world"))
                count++;
        }
        System.out.println(count);
        reader.close();
        fileReader.close();
    }
}