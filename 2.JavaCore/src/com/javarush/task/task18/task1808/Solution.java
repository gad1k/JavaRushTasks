package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();
        FileInputStream fileName1 = new FileInputStream(path1);
        FileOutputStream fileName2 = new FileOutputStream(path2);
        FileOutputStream fileName3 = new FileOutputStream(path3);
        byte[] buffer = new byte[fileName1.available() / 2 + fileName1.available() % 2];
        fileName1.read(buffer);
        fileName2.write(buffer);
        int count = fileName1.read(buffer);
        fileName3.write(buffer, 0, count);
        fileName1.close();
        fileName2.close();
        fileName3.close();
    }
}