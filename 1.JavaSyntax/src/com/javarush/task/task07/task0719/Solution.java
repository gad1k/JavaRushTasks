package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++)
            list[i] = Integer.parseInt(reader.readLine());
        for (int i = list.length - 1; i >= 0; i--)
            System.out.println(list[i]);
    }
}