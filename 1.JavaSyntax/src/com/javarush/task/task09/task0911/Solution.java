package com.javarush.task.task09.task0911;

import java.util.HashMap;

/* 
Исключение при работе с коллекциями Map
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try {
            HashMap<String, String> map = new HashMap<>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException e) {
            //напишите тут ваш код
            System.out.println(e);
        }
    }
}