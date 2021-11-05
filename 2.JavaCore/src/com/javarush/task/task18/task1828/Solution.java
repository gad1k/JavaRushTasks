package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile = reader.readLine();
        FileInputStream fileIn = new FileInputStream(pathFile);
        List<String> allEntry = new ArrayList<String>();
        Scanner scanner = new Scanner(fileIn);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            allEntry.add(line);
        }
        fileIn.close();
        try {
            switch (args[0]) {
                case "-u":
                    for (int i = 0; i < allEntry.size(); i++)
                        if (allEntry.get(i).startsWith(args[1]))
                            allEntry.set(i, String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                    break;
                case "-d":
                    Iterator<String> iter = allEntry.iterator();
                    while (iter.hasNext()) {
                        String entry = iter.next();
                        if (entry.startsWith(args[1]))
                            iter.remove();
                    }
                    break;
            }
            FileOutputStream fileOut = new FileOutputStream(pathFile);
            for (String entry : allEntry)
                fileOut.write(String.format("%s%n", entry).getBytes());
            fileOut.close();
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
}