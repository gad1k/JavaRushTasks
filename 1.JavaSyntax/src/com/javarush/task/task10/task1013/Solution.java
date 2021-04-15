package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }
    public static class Human {
        // напишите тут ваши переменные и конструкторы
        String firstName;
        String lastName;
        int age;
        int weight;
        int height;
        int sex;
        public Human(String firstName, String lastName, int age, int weight, int height, int sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.sex = sex;
        }
        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;

        }
        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Human(String firstName, String lastName, int age, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
        }
        public Human(String firstName, String lastName, int age, int weight, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
        public Human(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }
        public Human(String firstName, int age, int weight) {
            this.firstName = firstName;
            this.age = age;
            this.weight = weight;

        }
        public Human(String firstName, int age, int weight, int height) {
            this.firstName = firstName;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
        public Human(String firstName,  int age, int weight, int height, int sex) {
            this.firstName = firstName;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.sex = sex;
        }
        public Human(int age, int weight, int height, int sex) {
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.sex = sex;
        }
    }
}