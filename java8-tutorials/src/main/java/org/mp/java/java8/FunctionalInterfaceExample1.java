package org.mp.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * The program uses Predicate functional interface provided by java8 to perfrom
 * different operation on list.
 */
public class FunctionalInterfaceExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Printing all numbers from list...");
        Predicate<Integer> allNumber = n -> true;
        eval(numbers, allNumber);

        System.out.println("\nPrinting Even numbers from list...");
        eval(numbers, n -> n % 2 == 0);

        System.out.println("\nPrinting numbers between 3 and 7 from list...");
        eval(numbers, n -> n > 3 && n < 7);

        List<String> users = Arrays.asList("Manoj", "Raja", "Sai", "Ram", "Krishan");

        System.out.println("\nPrinting users who's name length less than or equal to 3...");
        eval(users, n -> n.length() <= 3);

        System.out.println("\nPrinting users who's name start with R...");
        eval(users, n -> n.charAt(0) == 'R');

    }

    private static <E> void eval(List<E> list, Predicate<E> predicate) {
        for (E item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
    }

}