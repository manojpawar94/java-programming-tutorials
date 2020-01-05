package org.mp.java.java8.example.functionalinteface;

import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceExample2 {
    
    public static void main(String[] args) {
        /**
         * The Java Consumer interface is a functional interface that represents an
         * function that consumes a value without returning any value. A Java Consumer
         * implementation could be printing out a value, or writing it to a file, or
         * over the network etc. Here is an example implementation of the Java Consumer
         * interface:
         */
        Consumer<Integer> consumer = value -> System.out.println("Consumer has accepted : " + value);
        consumer.accept(12);

        /**
         * The Java Supplier interface is a functional interface that represents an
         * function that supplies a value of some sorts. The Supplier interface can also
         * be thought of as a factory interface. Here is an example implementation of
         * the Java Supplier interface:
         */
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        System.out.println("Supplier has provided : " + randomNumber.get());

        /**
         * The Java BinaryOperator interface is a functional interface that represents
         * an operation which takes two parameters and returns a single value. Both
         * parameters and the return type must be of the same type.
         * 
         * The Java BinaryOperator interface is useful when implementing functions that
         * sum, subtract, divide, multiply etc. two elements of the same type, and
         * returns a third element of the same type.
         * 
         * Here is an example implementation of the BinaryOperator interface
         */
        BinaryOperator<Integer> addition = (value1, value2) -> value1 + value2;
        System.out.println("BinaryOperator has apply additoin on random number is : "
                + addition.apply(randomNumber.get(), randomNumber.get()));

        /**
         * The Java UnaryOperator interface is a functional interface that represents an
         * operation which takes a single parameter and returns a parameter of the same
         * type. Here is an example of a Java UnaryOperator implementation:
         */
        UnaryOperator<Person> unaryOperator = (person) -> {
            person.name = "New Name";
            return person;
        };
        System.out.println(unaryOperator.apply(new FunctionalInterfaceExample2().new Person()).toString());
    }

    class Person {
        String name;

        @Override
        public String toString() {
            return "Person [ name = " + name + " ]";
        }

    }
}