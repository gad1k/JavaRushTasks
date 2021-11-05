package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static ArrayList<String> fc1 = new ArrayList<String>();
    public static ArrayList<String> fc2 = new ArrayList<String>(5);
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = conReader.readLine();
        String file2 = conReader.readLine();
        conReader.close();
        BufferedReader f1 = new BufferedReader(new FileReader(file1));
        BufferedReader f2 = new BufferedReader(new FileReader(file2));
        while (f1.ready())
            fc1.add(f1.readLine());
        f1.close();
        while (f2.ready())
            fc2.add(f2.readLine());
        f2.close();
        for (int i = 0; i < fc1.size(); i++) {
            try {
                if (fc1.get(i).equals(fc2.get(0))) {
                    lines.add(new LineItem(Type.SAME, fc1.get(i)));
                    fc2.remove(0);
                } else if (fc1.get(i).equals(fc2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, fc2.get(0)));
                    fc2.remove(0);
                    i--;
                } else {
                    lines.add(new LineItem(Type.REMOVED, fc1.get(i)));
                }
            } catch (IndexOutOfBoundsException e){
                if (fc1.size() > fc2.size())
                    lines.add(new LineItem(Type.REMOVED, fc1.get(i)));
                if (fc1.size() < fc2.size())
                    lines.add(new LineItem(Type.ADDED, fc2.get(0)));
            }
        }
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}