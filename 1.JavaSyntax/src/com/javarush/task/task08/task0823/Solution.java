package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //напишите тут ваш код
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[0] = Character.toUpperCase(array[0]);
            if (array[i] == ' ')
                array[i + 1] = Character.toUpperCase(array[i + 1]);
        }
        s = new String(array);
        System.out.println(s);
    }
}