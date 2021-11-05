package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String pathIn = reader.readLine();
        String pathOut = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(pathIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathOut));
        while (fileReader.ready())
            stringBuilder.append((char) fileReader.read());
        for (String entry : stringBuilder.toString().split(" "))
            if (entry.matches("\\d*"))
                fileWriter.write(entry + " ");
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}