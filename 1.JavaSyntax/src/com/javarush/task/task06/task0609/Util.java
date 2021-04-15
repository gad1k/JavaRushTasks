package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        return Math.sqrt(Math.pow(Math.abs(x1) - Math.abs(x2), 2) + Math.pow(Math.abs(y1) - Math.abs(y2), 2));
    }
    public static void main(String[] args) {
    }
}