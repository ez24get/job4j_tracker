package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("Compare length " + right.length() + " and " + left.length());
            return Integer.compare(right.length(), left.length());
            };
        strings.sort(comparator);
        System.out.println("Result is: ");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}