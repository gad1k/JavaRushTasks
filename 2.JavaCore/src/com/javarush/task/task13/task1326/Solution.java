package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner input = new Scanner(System.in);
        FileInputStream path = new FileInputStream(input.nextLine());
        input = new Scanner(path);
        ArrayList<Integer> result = new ArrayList<>();
        while (input.hasNextLine())
            result.add(Integer.parseInt(input.nextLine()));
        Collections.sort(result);
        for (int curInt : result)
            if (curInt % 2 == 0)
                System.out.println(curInt);
        input.close();
    }
}