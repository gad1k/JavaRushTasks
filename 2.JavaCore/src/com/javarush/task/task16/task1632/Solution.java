package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static class Thread1 extends Thread {
        public void run() {
            while (true) {
            }
        }
    }
    public static class Thread2 extends Thread {
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message {
        public void showWarning() {
            Thread.interrupted();
        }
        public void run() {
            showWarning();
        }
    }
    public static class Thread5 extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int result = 0;
            String tmp;
            try {
                while (!((tmp = reader.readLine()).equals("N"))) {
                    result += Integer.parseInt(tmp);
                }
                System.out.println(result);
            } catch (IOException e) {
            }
        }
    }
    public static void main(String[] args) {
        for (Thread item : threads)
            item.start();
    }
}