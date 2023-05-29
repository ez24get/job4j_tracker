package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> Integer.compare(right.length(), left.length());
        System.out.println("Descending comparison:");
        strings.sort(comparator);
        for (String str : strings) {
            System.out.println("Длина строки " + str + " - " + str.length());
        }
    }
}