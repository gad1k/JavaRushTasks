package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> x2 = new ArrayList<>();
        ArrayList<Integer> x3 = new ArrayList<>();
        ArrayList<Integer> xOther = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            list.add(Integer.parseInt(reader.readLine()));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                x2.add(list.get(i));
            if (list.get(i) % 3 == 0)
                x3.add(list.get(i));
            if ((list.get(i) % 2 != 0) && (list.get(i) % 3 != 0))
                xOther.add(list.get(i));
        }
        printList(x3);
        printList(x2);
        printList(xOther);
    }
    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}