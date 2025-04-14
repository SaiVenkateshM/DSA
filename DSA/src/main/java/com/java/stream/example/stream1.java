package com.java.stream.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stream1 {
    public static void main(String[] args) {
        String s1 = "Hello World";
        // first to convert this string to stream which is done by chars()
        Map<Character,Long> chCount = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));






    }
}
