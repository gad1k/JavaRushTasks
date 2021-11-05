package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile = reader.readLine();
        FileInputStream fileIn = new FileInputStream(pathFile);
        Scanner searchMaxId = new Scanner(fileIn);
        List<String> list = new ArrayList<String>();
        int countId = 0;
        while (searchMaxId.hasNext()) {
            String line = searchMaxId.nextLine();
            list.add(line);
            if (Integer.parseInt(line.substring(0, 8).trim()) > countId)
                countId = Integer.parseInt(line.substring(0, 8).trim());
        }
        fileIn.close();
        try {
            switch (args[0]) {
                case "-c":
                    FileOutputStream fileOut = new FileOutputStream(pathFile);
                    for (String line : list)
                        fileOut.write(String.format("%s%n", line).getBytes());
                    fileOut.write(String.format("%-8s%-30s%-8s%-4s%n", countId + 1, args[1], args[2], args[3]).getBytes());
                    fileOut.close();
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No Arguments");
        }
    }
}