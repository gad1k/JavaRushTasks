package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        String path;
        FileInputStream fileIn;
        while (!(path = scanner.nextLine()).equals("exit")) {
            fileIn = new FileInputStream(path);
            if (fileIn.available() < 1000) {
                fileIn.close();
                scanner.close();
                throw new DownloadException();
            }
        }
    }
    public static class DownloadException extends Exception {
    }
}