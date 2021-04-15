package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }
        // ввод строк
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        // напишите тут ваш код
/*        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++)
            map.put(alphabet.get(i).toString(), 0);
        for (Map.Entry<String, Integer> pair : map.entrySet())
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).equals(pair.getKey()))
                    pair.setValue(pair.getValue() + 1);
        for (int i = 0; i < abcArray.length; i++)
            System.out.println(alphabet.get(i).toString() + ' ' + map.get(alphabet.get(i).toString()));*/
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j <list.get(i).length(); j++)
                for (int k = 0; k < alphabet.size() ; k++) {
                    if (map.get(alphabet.get(k)) == null)
                        map.put(alphabet.get(k), 0);
                    if (list.get(i).charAt(j) == alphabet.get(k))
                        map.put(alphabet.get(k), (map.get(alphabet.get(k)).intValue() + 1));
                }
        for (int i = 0; i < map.size(); i++)
            System.out.println(alphabet.get(i) + " " + map.get(alphabet.get(i)));
    }
}