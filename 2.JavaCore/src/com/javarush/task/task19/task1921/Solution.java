package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Pattern p = Pattern.compile("\\D \\d");
        Matcher m;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
        String str, name, birthday;
        while (reader.ready()) {
            str = reader.readLine();
            m = p.matcher(str);
            if (m.find()) {
                name = str.substring(0, m.start() + 1);
                birthday = str.substring(m.start() + 2, str.length());
                PEOPLE.add(new Person(name, simpleDateFormat.parse(birthday)));
            }
        }
        reader.close();
    }
}