package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        int index;
        String line;
        Scanner scanner = new Scanner(System.in);
        FileInputStream pathFile = new FileInputStream(scanner.nextLine());
        Scanner nameFile = new Scanner(pathFile);
        Map<Integer, String> map = new HashMap<Integer, String>();
        while (nameFile.hasNextLine()) {
            line = nameFile.nextLine();
            index = line.indexOf(" ");
            map.put(Integer.parseInt(line.substring(0, index)), line);
        }
        System.out.println(map.get(Integer.parseInt(args[0])));
        pathFile.close();
    }
}