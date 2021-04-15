package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //list of addresses
/*        List<String> addresses = new ArrayList<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty())
                break;
            addresses.add(family);
        }*/
        //read home number
/*        int houseNumber = Integer.parseInt(reader.readLine());
        if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familySecondName = addresses.get(houseNumber);
            System.out.println(familySecondName);
        }*/
        Map<String, String> addresses = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty())
                break;
            addresses.put(city, reader.readLine());
        }
        String city = reader.readLine();
        for (Map.Entry<String, String> pair : addresses.entrySet())
            if (pair.getKey().equalsIgnoreCase(city)) {
                System.out.println(pair.getValue());
                break;
            }
    }
}