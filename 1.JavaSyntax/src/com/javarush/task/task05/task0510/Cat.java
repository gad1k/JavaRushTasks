package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name, address, color;
    private int weight, age;

    public void initialize(String name) {
        this.name = name;
        this.weight = 5;
        this.age = 3;
        this.color = null;
        this.address = null;
    }
    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = null;
        this.address = null;
    }
    public void initialize(String name, int age) {
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.color = null;
        this.address = null;
    }
    public void initialize(int weight, String color) {
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.address = null;
    }
    public void initialize(int weight, String color, String address) {
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.color = null;
        this.address = address;
    }
    public static void main(String[] args) {
    }
}