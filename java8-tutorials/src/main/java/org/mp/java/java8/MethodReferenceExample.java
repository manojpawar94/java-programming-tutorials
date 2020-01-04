package org.mp.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            numbers.add(new Random().nextInt(100));
        }

        // method reference to print the element of list
        numbers.forEach(System.out::println);
    }
}