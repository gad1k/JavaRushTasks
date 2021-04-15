package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listMultiLine = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty())
                break;
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 0)
                listMultiLine.add(list.get(i) + " " + list.get(i));
            else
                listMultiLine.add(list.get(i) + " " + list.get(i) + " " + list.get(i));
        }
        for (String s : listMultiLine) {
            System.out.println(s);
        }
    }
}