package com.module2.module2.lambdas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
//    Stream, sorting, filter, map, Collectors
    public static void main(String[] args) {
        List<String> fruits = List.of("A", "FGHI", "DEF", "BC");
//        Stream<String> stream = fruits.stream();
//        stream.forEach((fruit) -> {
//            System.out.println(fruit);
//        });
//        stream is consumed.
//        System.out.println(stream.count());

//        stream is used if you don't want to use up a lot of data.
//        map is used to convert one type to another type

        Stream<String> stream2 = fruits.stream();
        stream2
                .filter(fruit -> fruit.length() < 3)
                .sorted() // Stream<String> closed
                .map((fruit) -> {
                    System.out.println(fruit);
                    return fruit.length();
                }) // Stream<Integer> closed
                .map(fruit -> 2*fruit)
                .forEach(System.out::println);

        List<String> manyFruits = List.of("Apple", "Mango", "Banana", "Kiwi");
        Stream<String> stream3 = manyFruits.stream();
//        store length of fruits
        List<Integer> fruitsLengths = stream3
                .map(String::length)
                .toList();
        System.out.println(fruitsLengths);

//        store a map of fruit and its length
        Map<String, Integer> fruitsLengthMap = manyFruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
//                        fruit -> fruit.length()
                        String::length
                ));

        System.out.println(fruitsLengthMap);
    }
}
