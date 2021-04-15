package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int size_min = Integer.MAX_VALUE, size_max = Integer.MIN_VALUE, pos_min = 0, pos_max = 0;
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            if (list.get(i).length() < size_min) {
                size_min = list.get(i).length();
                pos_min = i;
            }
            if (list.get(i).length() > size_max) {
                size_max = list.get(i).length();
                pos_max = i;
            }
        }
        if (pos_min < pos_max)
            System.out.println(list.get(pos_min));
        else
            System.out.println(list.get(pos_max));
    }
}