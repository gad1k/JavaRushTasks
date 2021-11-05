package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {
    }
    public interface Fly {
        void fly();
    }
    public interface Move {
        void move();
    }
    public interface Eat {
        void eat();
    }
    public abstract class Dog implements Move, Eat {
    }
    public abstract class Duck implements Fly, Move, Eat {
    }
    public abstract class Car implements Move {
    }
    public abstract class Airplane implements Fly, Move {
    }
}