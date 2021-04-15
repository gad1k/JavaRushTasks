package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat("Cat1", 2, 2, 3);
        Cat cat2 = new Cat("Cat2", 9, 4, 7);
        Cat cat3 = new Cat("Cat3", 5, 3, 6);
        System.out.println("Cat1 vs Cat2: " + cat1.fight(cat2));
        System.out.println("Cat1 vs Cat3: " + cat1.fight(cat3));
        System.out.println("Cat2 vs Cat3: " + cat2.fight(cat3));
    }
    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;
        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;
            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}