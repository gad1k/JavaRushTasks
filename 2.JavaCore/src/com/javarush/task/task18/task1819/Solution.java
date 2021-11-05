package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileInputStream fileName1In = new FileInputStream(path1);
        FileInputStream fileName2In = new FileInputStream(path2);
        byte[] buffer1 = new byte[fileName1In.available()];
        byte[] buffer2 = new byte[fileName2In.available()];
        fileName1In.read(buffer1);
        fileName2In.read(buffer2);
        FileOutputStream fileName1Out = new FileOutputStream(path1);
        fileName1Out.write(buffer2);
        fileName1Out.write(buffer1);
        fileName1Out.close();
        fileName2In.close();
        fileName1In.close();
    }
}