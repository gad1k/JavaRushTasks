package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathIn = reader.readLine();
        String pathOut = reader.readLine();
        reader.close();
        FileInputStream fileIn = new FileInputStream(pathIn);
        FileOutputStream fileOut = new FileOutputStream(pathOut);
        byte[] buffer = new byte[fileIn.available()];
        fileIn.read(buffer);
        for (int i = buffer.length - 1; i >= 0 ; i--)
            fileOut.write(buffer[i]);
        fileOut.close();
        fileIn.close();
    }
}