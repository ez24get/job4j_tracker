package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> usage = new HashMap<>();
        usage.put("johndowe@gmail.com", "John Ramires Dowe");
        usage.put("johndowe@gmail.com", "Dowe");
        usage.put("johndowe@gmail.com", "John R");
        usage.put("john@gmail.com", "John Ramires Dowe");
        usage.put("jo@gmail.com", "John Ramires Dowe");
        for (String key : usage.keySet()) {
            String value = usage.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
