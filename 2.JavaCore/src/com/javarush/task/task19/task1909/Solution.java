package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(reader.readLine()));
        String str = fileIn.readLine();
        fileOut.write(str.replace(".", "!"));
        reader.close();
        fileIn.close();
        fileOut.close();
    }
}