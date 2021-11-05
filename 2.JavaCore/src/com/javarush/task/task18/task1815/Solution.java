package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface instance;
        public TableInterfaceWrapper(ATableInterface instance) {
            this.instance = instance;
        }
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            instance.setModel(rows);
        }
        @Override
        public String getHeaderText() {
            return instance.getHeaderText().toUpperCase();
        }
        @Override
        public void setHeaderText(String newHeaderText) {
            instance.setHeaderText(newHeaderText);
        }
    }
    public interface ATableInterface {
        void setModel(List rows);
        String getHeaderText();
        void setHeaderText(String newHeaderText);
    }
    public static void main(String[] args) {
    }
}