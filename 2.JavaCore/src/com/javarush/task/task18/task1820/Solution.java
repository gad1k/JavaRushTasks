package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathIn = reader.readLine();
        String pathOut = reader.readLine();
        FileInputStream fileIn = new FileInputStream(pathIn);
        FileOutputStream fileOut = new FileOutputStream(pathOut);
        byte[] buffer = new byte[fileIn.available()];
        fileIn.read(buffer);
        String[] arrSplit = new String(buffer).split(" ");
        for (String stringToFloat : arrSplit) {
            long var = Math.round(Double.parseDouble(stringToFloat));
            String floatToString = var + " ";
            fileOut.write(floatToString.getBytes());
        }
        fileOut.close();
        fileIn.close();
    }
}