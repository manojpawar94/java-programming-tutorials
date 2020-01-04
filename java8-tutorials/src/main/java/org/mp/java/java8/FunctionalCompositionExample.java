package org.mp.java.java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalCompositionExample {
    public static void main(String[] args) {
        Predicate<String> startWithA = text -> text.startsWith("A");
        Predicate<String> endWithX = text -> text.toUpperCase().endsWith("X");

        // without composition
        Predicate<String> withoutComposition = text -> startWithA.test(text) && endWithX.test(text);

        /**
         * The Predicate and() method is a default method. The and() method is used to
         * combine two other Predicate functions in the same way I showed in the
         * beginning of this Java functional composition tutorial. Here is an example of
         * functional composition with the Predicate and() method:
         */
        Predicate<String> withCompositionAnd = startWithA.and(endWithX);

        String testString1 = "A hardworking person must relax";
        String testString2 = "A hardworking person must relax sometimes";

        System.out.println("Result without composition: " + withoutComposition.test(testString1));
        System.out.println("Result with composition And on test String 1: " + withCompositionAnd.test(testString1));
        System.out.println("Result with composition And on test String 2: " + withCompositionAnd.test(testString2));

        /**
         * The Predicate or() method is used to combine a Predicate instance with
         * another, to compose a third Predicate instance. The composed Predicate will
         * return true if either of the Predicate instances it is composed from return
         * true, when their test() methods are called with same input parameter as the
         * composed Predicate. Here is a Java Predicate or() functional composition
         * example:
         */
        Predicate<String> withCompositionOr = startWithA.or(endWithX);
        System.out.println("Result with composition Or on test String 1: " + withCompositionOr.test(testString1));
        System.out.println("Result with composition Or on test String 2: " + withCompositionOr.test(testString2));

        Function<Integer, Integer> add = value -> value + 2;
        Function<Integer, Integer> multiple = value -> value * 2;

        /**
         * The Java Function compose() method composes a new Function instance from the
         * Function instance it is called on, and the Function instance passed as
         * parameter to the compose() method.
         * 
         * The Function returned by compose() will first call the Function passed as
         * parameter to compose(), and then it will call the Function which compose()
         * was called on. This is easier to understand with an example, so here is a
         * Java Function compose() example:
         */
        Function<Integer, Integer> addThenMultiple = multiple.compose(add);
        System.out.println("adding num {2} by 2 and multiple by 2 is " + addThenMultiple.apply(2));

        /**
         * The Java Function andThen() method works opposite of the compose() method. A
         * Function composed with andThen() will first call the Function that andThen()
         * was called on, and then it will call the Function passed as parameter to the
         * andThen() method. Here is a Java Function andThen() example:
         */
        Function<Integer, Integer> multipleAndAdd = multiple.andThen(add);
        System.out.println("multiple num {2} by 2 and add by 2 is " + multipleAndAdd.apply(2));
    }
}