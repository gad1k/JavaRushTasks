package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        while (fileIn.ready()) {
            String str = fileIn.readLine();
            String[] splittedStr = str.split(" ");
            for (String entry : splittedStr) {
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(entry);
                if (m.find())
                    fileOut.write(entry + " ");
            }
        }
        fileIn.close();
        fileOut.close();
    }
}