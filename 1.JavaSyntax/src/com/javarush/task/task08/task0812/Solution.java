package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1, max_count = 0;
        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1))
                count++;
            else {
                if (count > max_count)
                    max_count = count;
                count = 1;
            }
        }
        if (count > max_count)
            max_count = count;
        System.out.println(max_count);
    }
}