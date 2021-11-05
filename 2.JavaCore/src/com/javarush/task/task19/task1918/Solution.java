package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader(reader.readLine());
        FileReader fileReader = new FileReader("e:\\java\\src.txt");
//        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready())
            sb.append((char) fileReader.read());
        fileReader.close();
        String str = sb.toString().replaceAll("\\r\\n", "");
        Pattern p = Pattern.compile("<tag|</tag>");
        Matcher mStart = p.matcher(str);
        System.out.println(str);
        System.out.println("----------------------------------");
        while (mStart.find()) {
            }
        }
}