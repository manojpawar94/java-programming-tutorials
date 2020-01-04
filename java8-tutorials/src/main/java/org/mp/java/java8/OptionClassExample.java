package org.mp.java.java8;

import java.util.Optional;

/**
 * Optional is a container object used to contain not-null objects. Optional
 * object is used to represent null with absent value. This class has various
 * utility methods to facilitate code to handle values as ‘available’ or ‘not
 * available’ instead of checking null values. It is introduced in Java 8 and is
 * similar to what Optional is in Guava.
 */
public class OptionClassExample {

    private static Optional<String> optionalValue;

    public static void main(String[] args) {
        // Optional.ofNullable - allows passed parameter to be null.
        String value1 = null;
        optionalValue = Optional.ofNullable(value1);

        // isPresent return true if there is a value present, otherwise false.
        if (optionalValue.isPresent()) {
            System.out.println("Value (using isPresent): " + optionalValue.get());
        } else {
            System.out.println("Cannot get the substring from an empty string variable value1");
        }

        value1 = "Game of Thrones";
        optionalValue = Optional.ofNullable(value1);
        // isPresent return true if there is a value present, otherwise false.
        if (optionalValue.isPresent()) {
            System.out.println("Value (using isPresent): " + optionalValue.get());
        } else {
            System.out.println("Cannot get the substring from an empty string variable value1");
        }

        // Optional.empty() creates an empty Optional object
        Optional<String> optionalEmpty = Optional.empty();

        optionalValue.ifPresent(value -> System.out.println("Values (using ifPresent): " + value));
        // below sysout will not print as optionalEmpty Optional instance is empty,
        // don't have value
        optionalEmpty.ifPresent(value -> System.out.println("Values (using ifPresent): " + value));

        /**
         * Optional orElse() and orElseGet() methods returns the value of Optional
         * Object if it is no empty, if the object is empty then it returns the default
         * value passed to this method as an argument.
         */
        System.out.println("Value of optionalValue1 (using orElse()): " + optionalValue.orElse("Default-Value"));
        System.out.println("Value of optionalEmpty (using orElse()): " + optionalEmpty.orElse("Default-Value"));

        System.out.println("Value of optionalValue1 (using orElseGet()): " + optionalValue.orElseGet(() -> "Default-Value"));
        System.out.println("Value of optionalEmpty (using orElseGet()): " + optionalEmpty.orElseGet(() -> "Default-Value"));

        /**
         * Optional.map():- If a value is present, applies the provided mapping function
         * to it, and if the result is non-null, returns an Optional describing the
         * result.
         */
        System.out.println("Value of optionalValue1 in Uppercase (using map): " + optionalValue.map(String::toUpperCase));
        System.out.println("Value of optionalEmpty in Uppercase (using map): " + optionalEmpty.map(String::toUpperCase));

        /**
         * of() returns an Optional with the specified present non-null value.
         */
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("NestedOptional"));
        System.out.println("Value of nestedOptional object: " + nestedOptional);
        System.out.println("map on nestedOptional object: " + nestedOptional.map(value -> value.map(String::toLowerCase)));
        
        /**
         * flatMap(): - If a value is present, apply the provided Optional-bearing
         * mapping function to it, return that result, otherwise return an empty
         * Optional. This method is similar to map(Function), but the provided mapper is
         * one whose result is already an Optional, and if invoked, flatMap does not
         * wrap it with an additional Optional.
         */
        System.out.println("flatMap on nestedOptional object: " + nestedOptional.flatMap(value -> value.map(String::toLowerCase)));

        /**
         * filter():- If a value is present and the value matches a given predicate, it
         * returns an Optional describing the value, otherwise returns an empty
         * Optional.
         */
        System.out.println("Filter on Value1 : " + optionalValue.filter(value -> value.equals("GAME OF THRONES")));
        System.out.println("Filter on Value1 : " + optionalValue.filter(value -> value.equalsIgnoreCase("GAME OF THRONES")));

    }
}
     
/**
 --------------------------------------------------------------------
 * Output: 
 --------------------------------------------------------------------
Cannot get the substring from an empty string variable value1
Value (using isPresent): Game of Thrones
Values (using ifPresent): Game of Thrones
Value of optionalValue1 (using orElse()): Game of Thrones
Value of optionalEmpty (using orElse()): Default-Value
Value of optionalValue1 (using orElseGet()): Game of Thrones
Value of optionalEmpty (using orElseGet()): Default-Value
Value of optionalValue1 in Uppercase (using map): Optional[GAME OF THRONES]
Value of optionalEmpty in Uppercase (using map): Optional.empty
Value of nestedOptional object: Optional[Optional[NestedOptional]]
map on nestedOptional object: Optional[Optional[nestedoptional]]
flatMap on nestedOptional object: Optional[nestedoptional]
Filter on Value1 : Optional.empty
Filter on Value1 : Optional[Game of Thrones]
-------------------------------------------------------------------- 
*/