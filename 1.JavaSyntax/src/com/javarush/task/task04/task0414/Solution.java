package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());
        if ((year % 4 )== 0) {
            if ((year % 100) == 0) {
                if ((year % 400) == 0)
                    System.out.println("количество дней в году: 366");
                else
                    System.out.println("количество дней в году: 365");
            }
            else
                System.out.println("количество дней в году: 365");
        }
        else
            System.out.println("количество дней в году: 365");
    }
}