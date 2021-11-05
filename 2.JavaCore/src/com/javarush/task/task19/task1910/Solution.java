package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(reader.readLine()));
        String str = fileIn.readLine();
        fileOut.write(str.replaceAll("\\p{Punct}", ""));
        reader.close();
        fileIn.close();
        fileOut.close();
    }
}