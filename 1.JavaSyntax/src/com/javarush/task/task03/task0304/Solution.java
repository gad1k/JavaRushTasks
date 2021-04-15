package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        //напишите тут ваш код
        return 0.1 * i + i;
    }
    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}