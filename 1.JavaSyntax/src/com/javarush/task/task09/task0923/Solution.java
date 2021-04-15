package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] text = reader.readLine().toCharArray();
        List<Character> arVowel = new ArrayList<>();
        List<Character> arNotVowel = new ArrayList<>();
        for (char ch : text)
            if (isVowel(ch))
                arVowel.add(ch);
            else
                arNotVowel.add(ch);
        for (char ch : arVowel)
            System.out.print(ch + " ");
        System.out.println("");
        for (char ch : arNotVowel) {
            if (ch == ' ')
                continue;
            else
                System.out.print(ch + " ");
        }
    }
    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d)
                return true;
        }
        return false;
    }
}