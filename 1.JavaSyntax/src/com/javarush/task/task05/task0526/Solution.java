package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Andrei", 27, "Т.Абрaмова 42/16");
        Man man2 = new Man("Ruslan", 24, "Фабричная 57/21");
        Woman woman1 = new Woman("Olga", 26, "Т.Абрaмова 42/16");
        Woman woman2 = new Woman("Anna", 26, "Книжная 13/13");
        //выведи их на экран тут
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }
    //напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String address;
        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        private String name;
        private int age;
        private String address;
        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}