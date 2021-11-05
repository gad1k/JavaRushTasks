package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream instance;
    public QuestionFileOutputStream(AmigoOutputStream instance) {
        this.instance = instance;
    }
    @Override
    public void flush() throws IOException {
        instance.flush();
    }
    @Override
    public void write(int b) throws IOException {
        instance.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException {
        instance.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        instance.write(b, off, len);
    }
    @Override
    public void close() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (scanner.nextLine().toUpperCase().equals("Д"))
            instance.close();
    }
}