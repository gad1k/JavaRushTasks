package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
*/

public class Cat {
    public static void main(String[] args) {
    }
    //напишите тут ваш код
    protected void finalize() {
        System.out.println("Объект Cat уничтожен");
    }
}
class Dog {
    //напишите тут ваш код
    protected void finalize() {
        System.out.println("Объект Dog уничтожен");
    }
}