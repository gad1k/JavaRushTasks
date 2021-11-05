package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile, newFile;
        FileInputStream fileIn;
        FileOutputStream fileOut;
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        while (!(pathFile = reader.readLine()).equals("end")) {
            map.put(Integer.parseInt(pathFile.split("\\.part")[1]), pathFile);
        }
        newFile = map.get(map.firstKey()).split("\\.part")[0];
        new File(newFile).createNewFile();
        fileOut = new FileOutputStream(newFile);
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            fileIn = new FileInputStream(pair.getValue());
            byte[] buffer = new byte[fileIn.available()];
            fileIn.read(buffer);
            fileOut.write(buffer);
            fileIn.close();
        }
        fileOut.close();
    }
}