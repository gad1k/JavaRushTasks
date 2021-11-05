package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        while (!(fileName = scanner.nextLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
        scanner.close();
    }
    public static class ReadThread extends Thread {
        Map<Integer, Integer> threadMap = new HashMap<Integer, Integer>();
        String fileName;
        int key, max = Integer.MIN_VALUE;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream fileIn = new FileInputStream(fileName);
                while (fileIn.available() > 0) {
                    key = fileIn.read();
                    if (threadMap.containsKey(key))
                        threadMap.put(key, threadMap.get(key) + 1);
                    else
                        threadMap.put(key, 1);
                }
                for (Map.Entry<Integer, Integer> pair : threadMap.entrySet())
                    if (pair.getValue() > max)
                        max = pair.getValue();
                for (Map.Entry<Integer, Integer> pair : threadMap.entrySet())
                    if (pair.getValue() == max)
                        resultMap.put(fileName, pair.getKey());
                fileIn.close();
            } catch (IOException e) {
            }
        }
    }
}