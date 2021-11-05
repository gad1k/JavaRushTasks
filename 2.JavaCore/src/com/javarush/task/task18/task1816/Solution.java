package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream filePath = new FileInputStream(args[0]);
        int var, count = 0;
        while (filePath.available() > 0) {
            var = filePath.read();
            if (var >= 65 && var <= 122)
                count++;
        }
        System.out.println(count);
        filePath.close();
    }
}