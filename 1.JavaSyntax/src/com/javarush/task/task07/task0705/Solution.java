package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arBig = new int[20];
        for (int i = 0; i < arBig.length; i++)
            arBig[i] = Integer.parseInt(reader.readLine());
        int[] arSmall01 = new int[10];
        int[] arSmall02 = new int[10];
        for (int i = 0; i < arBig.length; i++) {
            if (i < 10)
                arSmall01[i] = arBig[i];
            else
                arSmall02[i - arSmall02.length] = arBig[i];
        }
        for (int i = 0; i < arSmall02.length; i++)
            System.out.println(arSmall02[i]);
    }
}