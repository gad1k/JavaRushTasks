package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }
    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Гришечкин", "Андрей");
        map.put("Гришечкин", "Руслан");
        map.put("Даниленко", "Анна");
        map.put("Курганская", "Елена");
        map.put("Кабков", "Владислав");
        map.put("Борисевич", "Ольга");
        map.put("Горбачева", "Анна");
        map.put("Чуешов", "Руслан");
        map.put("Филипков", "Иван");
        map.put("Чуешов", "Василий");
        return map;

    }
    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}