package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        int tmp;
        //напишите тут ваш код
        for (int i = 0; i < (N - 1); i++) {
            tmp = Integer.parseInt(reader.readLine());
            if (tmp > maximum)
                maximum = tmp;
        }
        System.out.println(maximum);
    }
}