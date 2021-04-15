package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Гришечкин", "Андрей");
        map.put("Петров", "Руслан");
        map.put("Сидоров", "Дмитрий");
        map.put("Борисевич", "Ольга");
        map.put("Горбачева", "Вера");
        map.put("Даниленко", "Анна");
        map.put("Кабков", "Владислав");
        map.put("Иванов", "Андрей");
        map.put("Чуешова", "Мария");
        map.put("Филипков", "Иван");
        return map;
    }
    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int countName = 0;
        for (HashMap.Entry<String, String> pair : map.entrySet())
            if (pair.getValue().equals(name))
                countName++;
        return countName;
    }
    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int countLastName = 0;
        for (HashMap.Entry<String, String> pair : map.entrySet())
            if (pair.getKey().equals(lastName))
                countLastName++;
        return countLastName;
    }
    public static void main(String[] args) {
    }
}