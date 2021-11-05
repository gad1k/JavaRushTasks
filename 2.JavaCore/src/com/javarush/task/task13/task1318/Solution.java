package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(fileName.readLine());
        BufferedReader fileData = new BufferedReader(new InputStreamReader(inStream));
        while (fileData.ready()) {
            System.out.println(fileData.readLine());
        }
        fileName.close();
        fileData.close();
        inStream.close();
    }
}