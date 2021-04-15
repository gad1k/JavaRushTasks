package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    //напишите тут ваш код
    private String name, color;
    private int height;

    public void initialize(String name) {
        this.name = name;
        this.height = 75;
        this.color = "Black";
    }
    public void initialize(String name, int height) {
        this.name = name;
        this.height = height;
        this.color = "Black";
    }
    public void initialize(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }
    public static void main(String[] args) {
    }
}