package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }
    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] tmp = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list1.add("sad");
            list2.add("SDS");
            list3.add("Sds");
        }
        tmp[0] = list1;
        tmp[1] = list2;
        tmp[2] = list3;
        return tmp;
    }
    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list)
                System.out.println(s);
        }
    }
}