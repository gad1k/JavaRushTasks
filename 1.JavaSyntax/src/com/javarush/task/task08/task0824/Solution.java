package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child01 = new Human("Ребенок01", true, 18);
        Human child02 = new Human("Ребенок02", true, 15);
        Human child03 = new Human("Ребенок03", false, 11);
        Human father = new Human("Отец", true, 45, new ArrayList<>(Arrays.asList(child01, child02, child03)));
        Human mother = new Human("Мать", false, 42, new ArrayList<>(Arrays.asList(child01, child02, child03)));
        Human grandFather01 = new Human("Дедушка01", true, 78, new ArrayList<>(Arrays.asList(father)));
        Human grandMother01 = new Human("Бабушка01", false, 72, new ArrayList<>(Arrays.asList(father)));
        Human grandFather02 = new Human("Дедушка02", true, 77, new ArrayList<>(Arrays.asList(mother)));
        Human grandMother02 = new Human("Бабушка02", false, 70, new ArrayList<>(Arrays.asList(mother)));
        System.out.println(grandFather01);
        System.out.println(grandMother01);
        System.out.println(grandFather02);
        System.out.println(grandMother02);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child01);
        System.out.println(child02);
        System.out.println(child03);
    }
    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList();
        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;
                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}