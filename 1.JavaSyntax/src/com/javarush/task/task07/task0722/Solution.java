package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        String line;
        while (true) {
            line = reader.readLine();
            if (line.equals("end"))
                break;
            else
                list.add(line);
        }
        for (String s : list)
            System.out.println(s);
    }
}