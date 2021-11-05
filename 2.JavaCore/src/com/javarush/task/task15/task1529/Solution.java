package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
    }
    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (Exception e) {
        }
    }
    public static Flyable result;
    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();
        if (value.equals("helicopter"))
            result = new Helicopter();
        if (value.equals("plane")) {
            result = new Plane(Integer.parseInt(reader.readLine()));
        }
        reader.close();
    }
}