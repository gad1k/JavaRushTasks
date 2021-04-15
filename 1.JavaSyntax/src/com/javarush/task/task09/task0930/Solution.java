package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty())
                break;
            list.add(s);
        }
        String[] array = list.toArray(new String[list.size()]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }
    public static void sort(String[] array) {
        //напишите тут ваш код
        String tmp;
        int tmpI, tmpJ;
        for (int i = 0; i < array.length - 1; i++) {
            if (isNumber(array[i])) {
                for (int j = i + 1; j < array.length; j++) {
                    if (isNumber(array[j])) {
                        tmpI = Integer.parseInt(array[i]);
                        tmpJ = Integer.parseInt(array[j]);
                        if (tmpJ > tmpI) {
                            tmp = array[j];
                            array[j] = array[i];
                            array[i] = tmp;
                        }
                    } else
                        continue;
                }
            } else {
                for (int j = i + 1; j < array.length; j++) {
                    if (isNumber(array[j]))
                        continue;
                    else {
                        if (isGreaterThan(array[i], array[j])) {
                            tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;
                        }
                    }
                }
            }
        }
    }
    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0)
            return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) { // не цифра и не начинается с '-'
                return false;
            }
        }
        return true;
    }
}