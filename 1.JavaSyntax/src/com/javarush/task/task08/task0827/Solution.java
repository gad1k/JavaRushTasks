package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }
    public static boolean isDateOdd(String date) {
        Date endTime = new Date(date);
        Date startTime = new Date(endTime.getYear(), 1, 1, 0, 0, 0);
        int days = (int)((endTime.getTime() - startTime.getTime()) / (24 * 60 * 60 * 1000));
        if ((days + 1) % 2 == 0)
            return true;
        else
            return false;
    }
}