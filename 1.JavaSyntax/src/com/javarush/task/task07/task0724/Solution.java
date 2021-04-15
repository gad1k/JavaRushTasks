package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //напишите тут ваш код
        Human grandFather1 = new Human("Николай", true, 75, null, null);
        Human grandFather2 = new Human("Иван", true, 76, null, null);
        Human grandMother1 = new Human("Мария", false, 72, null, null);
        Human grandMother2 = new Human("Мария", false, 71, null, null);
        Human father = new Human("Дмитрий", true, 54, grandFather1, grandMother1);
        Human mother = new Human("Наталья", false, 49, grandFather2, grandMother2);
        Human child1 = new Human("Андрей", true, 27, father, mother);
        Human child2 = new Human("Руслан", true, 24, father, mother);
        Human child3 = new Human("Анна", false, 26, father, mother);
        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }
    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.father != null)
                text += ", отец: " + this.father.name;
            if (this.mother != null)
                text += ", мать: " + this.mother.name;
            return text;
        }
    }
}