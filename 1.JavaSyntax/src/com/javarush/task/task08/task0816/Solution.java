package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        //напишите тут ваш код
        map.put("Giggs", new Date("JULY 1 1980"));
        map.put("Messi", new Date("AUGUST 1 1980"));
        map.put("Ronaldo", new Date("SEPTEMBER 1 1980"));
        map.put("Pepe", new Date("NOVEMBER 1 1980"));
        map.put("Henry", new Date("DECEMBER 1 1980"));
        map.put("Vardy", new Date("JANUARY 1 1980"));
        map.put("Kaka", new Date("FEBRUARY 1 1980"));
        map.put("Koke", new Date("MARCH 1 1980"));
        map.put("Lloris", new Date("APRIL 1 1980"));
        return map;
    }
    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if ((pair.getValue().getMonth() == 5) || (pair.getValue().getMonth() == 6)
                    || (pair.getValue().getMonth() == 7))
                iterator.remove();
        }
    }
    public static void main(String[] args) {
    }
}