package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, count = 0, tmp;
        while(true) {
            tmp = Integer.parseInt(reader.readLine());
            if (tmp == -1)
                break;
            sum += tmp;
            count++;
        }
        System.out.println((float)sum / count);
    }
}