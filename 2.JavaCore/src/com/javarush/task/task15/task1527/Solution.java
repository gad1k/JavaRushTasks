package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        Pattern regexpPar = Pattern.compile("(\\?|&)[a-z]*(&|=)");
        Pattern regexpObj = Pattern.compile("(\\?|&)obj.+&");
        Matcher mPar = regexpPar.matcher(URL);
        Matcher mObj = regexpObj.matcher(URL);
        int position = 0;
        while (mPar.find(position)) {
            System.out.print(URL.substring(mPar.start() + 1, mPar.end() - 1) + " ");
            position = mPar.end() - 1;
        }
        System.out.println("");
        if (mObj.find())
            try {
                alert(Double.parseDouble(URL.substring(mObj.start() + 5, mObj.end() - 1)));
            } catch (Exception e) {
                alert(URL.substring(mObj.start() + 5, mObj.end() - 1));
            }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }
    public static void alert(String value) {
        System.out.println("String " + value);
    }
}