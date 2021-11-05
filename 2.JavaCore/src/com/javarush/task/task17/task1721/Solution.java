package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            setArrays(allLines, scanner.nextLine());
            setArrays(forRemoveLines, scanner.nextLine());
            scanner.close();
        } catch (IOException e) {
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
        }
    }
    public static void setArrays(List<String> list, String pathFile) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(pathFile));
        while (file.ready())
            list.add(file.readLine());
        file.close();
    }
    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}