package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int id;
        String key = args[0];
        switch (key) {
            case "-c":
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                else
                    allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                id = Integer.parseInt(args[1]);
                if (args[3].equals("м")) {
                    allPeople.get(id).setName(args[2]);
                    allPeople.get(id).setSex(Sex.MALE);
                    allPeople.get(id).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                } else {
                    allPeople.get(id).setName(args[2]);
                    allPeople.get(id).setSex(Sex.FEMALE);
                    allPeople.get(id).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                }
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                break;
            case "-i":
                id = Integer.parseInt(args[1]);
                System.out.println(allPeople.get(id).getName() + " "
                        + (allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж") + " "
                        + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(id).getBirthDay()));
                break;
        }
    }
}