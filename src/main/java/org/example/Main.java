package org.example;

import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface PiValue {
    double getPiValue();
}

@FunctionalInterface
interface StringReverser {
    String reversed(String s);
}

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "stream",
                "lambda", "array", "code", "programmer", "string", "double", "computer");

        List<String> containsO = words.stream()
                .filter(word -> word.contains("o"))
                .collect(Collectors.toList());
        System.out.println("\nWords that contain the letter 'O': " + containsO);

        List<String> containsOAndLongerThan5 = words.stream()
                .filter(word -> word.contains("o") && word.length() > 5)
                .collect(Collectors.toList());
        System.out.println("\nWords that contain the letter 'O' " +
                "and are longer than 5 letters: " + containsOAndLongerThan5);

        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        months.forEach(month -> System.out.println("Months of the year: " + month));

        months.forEach(System.out::println);

        PiValue piValue = () -> 3.1415;
        System.out.println("\nPi value: " + piValue.getPiValue());

        List<Object> mixedList = Arrays.asList("hello", 5, "world", "java", "stream", 2,
                "lambda", 4, "array", "code", "programmer", "string", 3, "double", "computer");
        List<Object> sortedMixedList = mixedList.stream()
                .sorted(Comparator.comparingInt(o -> o.toString().length()))
                .collect(Collectors.toList());
        System.out.println("\nExercise 6: " + sortedMixedList);

        List<Object> sortedMixedListDesc = mixedList.stream()
                .sorted(Comparator.comparingInt(o -> o.toString().length()).reversed())
                .collect(Collectors.toList());
        System.out.println("\nExercise 7: " + sortedMixedListDesc);

        StringReverser reverser = s -> new StringBuilder(s).reverse().toString();
        System.out.println("\nExercise 8: " + reverser.reversed("Hello world"));
    }
}
