package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        String str;
        String resultStr = new String();
        FileReader fileIn = new FileReader(args[0]);
        FileWriter fileOut = new FileWriter(args[1]);
        Scanner scanner = new Scanner(fileIn);
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            for (String entry : str.split(" "))
                if (entry.length() > 6)
                    resultStr += entry + ",";
        }
        fileOut.write(resultStr.substring(0, resultStr.length() - 1));
        fileIn.close();
        fileOut.close();
    }
}