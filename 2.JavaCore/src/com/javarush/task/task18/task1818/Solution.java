package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();
        FileOutputStream fileName1 = new FileOutputStream(path1);
        FileInputStream fileName2 = new FileInputStream(path2);
        FileInputStream fileName3 = new FileInputStream(path3);
        byte[] buffer1 = new byte[fileName2.available()];
        byte[] buffer2 = new byte[fileName3.available()];
        fileName2.read(buffer1);
        fileName3.read(buffer2);
        fileName1.write(buffer1);
        fileName1.write(buffer2);
        fileName3.close();
        fileName2.close();
        fileName1.close();
    }
}