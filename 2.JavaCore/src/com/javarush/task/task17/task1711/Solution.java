package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int id;
        switch (args[0]) {
            case "-c":
                //-c name1 sex1 bd1 name2 sex2 bd2 ...
                for (int i = 1; i < args.length; i += 3) {
                    synchronized (allPeople) {
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i],
                                    new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));
                        else
                            allPeople.add(Person.createFemale(args[i],
                                    new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                for (int i = 1; i < args.length; i += 4) {
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        if (args[i + 2].equals("м")) {
                            allPeople.get(id).setName(args[i + 1]);
                            allPeople.get(id).setSex(Sex.MALE);
                            allPeople.get(id).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]));
                        } else {
                            allPeople.get(id).setName(args[i + 1]);
                            allPeople.get(id).setSex(Sex.FEMALE);
                            allPeople.get(id).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]));
                        }
                    }
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                    }
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        System.out.println(allPeople.get(id).getName() + " "
                                + (allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж") + " "
                                + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(id).getBirthDay()));
                    }
                }
                break;
        }
    }
}