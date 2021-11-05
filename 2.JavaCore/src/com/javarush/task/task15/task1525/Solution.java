package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            FileInputStream inStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            while (reader.ready()) {
                String s = reader.readLine();
                lines.add(s);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
