package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Гришечкин", 800);
        map.put("Борисевич", 850);
        map.put("Тимошенко", 400);
        map.put("Страх", 300);
        map.put("Леонов", 440);
        map.put("Гарляк", 600);
        map.put("Малащенко", 790);
        map.put("Ноговицын", 680);
        map.put("Тесовец", 510);
        map.put("Иваненкова", 400);
        return (HashMap)map;
    }
    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (HashMap.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }
    public static void main(String[] args) {
    }
}