package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));
        while (fileIn.ready()) {
            stringBuffer = new StringBuffer(fileIn.readLine());
            System.out.println(stringBuffer.reverse());
        }
        reader.close();
        fileIn.close();
    }
}