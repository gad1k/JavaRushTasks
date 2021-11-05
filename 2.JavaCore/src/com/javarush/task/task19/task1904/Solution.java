package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {
    public static void main(String[] args) {
    }
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException {
            String entry = fileScanner.nextLine();
            return new Person(entry.split(" ")[0], entry.split(" ")[1], entry.split(" ")[2], new Date(entry.split(" ")[3]));
        }
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}