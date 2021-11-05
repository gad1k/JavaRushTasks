package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }
    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            FileInputStream inStream = new FileInputStream("e:/test.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<String> list = new ArrayList<>();
            String s = list.get(18);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object list[] = new String[1];
            list[0] = new Integer(5);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = null;
            Object x = new Integer(0);
            s = (String) x;
        } catch (ClassCastException e) {
                exceptions.add(e);
        }
        try {
            int[] list = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String str = "test";
            char c = str.charAt(20);
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}