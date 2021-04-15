package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum = 0;
        while (true) {
            line = reader.readLine();
            if (line.equals("сумма"))
                break;
            sum += Integer.parseInt(line);
        }
        System.out.println(sum);
    }
}