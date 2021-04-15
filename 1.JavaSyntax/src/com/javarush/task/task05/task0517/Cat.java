package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name, color, address;
    int age, weight;
    public Cat(String name) {
        this.name = name;
        this.weight = 5;
        this.age = 3;
        this.color = null;
        this.address = null;
    }
    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = null;
        this.address = null;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.color = null;
        this.address = null;
    }
    public Cat(int weight, String color) {
        this.name = null;
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.address = null;
    }
    public Cat(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.address = address;
    }
    public static void main(String[] args) {
    }
}