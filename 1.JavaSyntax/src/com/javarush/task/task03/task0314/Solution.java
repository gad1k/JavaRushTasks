package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Table(1);
        Table(2);
        Table(3);
        Table(4);
        Table(5);
        Table(6);
        Table(7);
        Table(8);
        Table(9);
        Table(10);
    }
    public static void Table (int a) {
        System.out.println(a * 1 + " " + a * 2 + " " + a * 3 + " " + a * 4 + " " + a * 5 + " " + a * 6 + " " + a * 7
                                 + " " + a * 8 + " " + a * 9 + " " + a * 10);
    }
}