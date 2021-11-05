package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(String value, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(String value) {
        System.out.println(value + value);
    }
    public static void printMatrix(int i) {
        System.out.println(i + i + i + i);
    }
    public static void printMatrix(int i, int j) {
        System.out.println(i + j + i + j);
    }
    public static void printMatrix(String value, int i) {
        System.out.println(i + value + value + i);
    }
    public static void printMatrix(int i, String value) {
        System.out.println("11111");
    }
    public static void printMatrix(String value1, String value2) {
        System.out.println(value1 + value2);
    }
    public static void printMatrix() {
        System.out.println("#######");
    }
}