package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Алилуев", "Юрий");
        map.put("Гришечкин", "Андрей");
        map.put("Дербеев", "Дмитрий");
        map.put("Иванов", "Денис");
        map.put("Кондриков", "Андрей");
        map.put("Кирюшкин", "Сергей");
        map.put("Поздняков", "Андрей");
        map.put("Слабоденюк", "Алексей");
        map.put("Коршунов", "Дмитрий");
        map.put("Саранчук", "Эдуард");
        return map;
    }
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            int count = 0;
            for (Map.Entry<String, String> firstNameDuplicate : copy.entrySet())
                if (firstNameDuplicate.getValue().equals(pair.getValue()))
                    count++;
            if (count >= 2)
                removeItemFromMapByValue(map, pair.getValue());
        }
    }
    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
    public static void main(String[] args) {
    }
}