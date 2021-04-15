package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/

public class Dog {
    //напишите тут ваш код
    private String name, color;
    private int height;
    public Dog(String name) {
        this.name = name;
        this.height = 75;
        this.color = null;
    }
    public Dog(String name, int height) {
        this.name = name;
        this.height = height;
        this.color = null;
    }
    public Dog(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }
    public static void main(String[] args) {
    }
}