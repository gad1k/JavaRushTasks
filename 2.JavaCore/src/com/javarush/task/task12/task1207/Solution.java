package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(5);
        print(new Integer(5));
    }
    //Напишите тут ваши методы
    public static void print(int a) {
        System.out.println("Type is int!");
    }
    public static void print(Integer b) {
        System.out.println("Type is Integer!");
    }
}