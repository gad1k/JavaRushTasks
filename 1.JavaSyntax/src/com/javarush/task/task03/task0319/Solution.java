package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int salary = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());
        System.out.println(name + " получает " + salary + " через " + year + " лет.");
    }
}