package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());
        reader.close();
        fileOut.write(outputStream.toByteArray());
        fileOut.close();
        System.out.println(outputStream.toString());
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}