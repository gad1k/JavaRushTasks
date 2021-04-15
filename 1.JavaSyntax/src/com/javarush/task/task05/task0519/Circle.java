package com.javarush.task.task05.task0519;

/* 
Ходим по кругу
*/

public class Circle {
    //напишите тут ваш код
    int centerX, centerY, radius, width;
    String color;
    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = 2 * radius;
        this.color = null;
    }
    public Circle(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = null;
    }
    public Circle(int centerX, int centerY, int radius, int width, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    public static void main(String[] args) {
    }
}