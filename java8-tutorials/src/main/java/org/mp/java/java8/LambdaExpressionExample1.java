package org.mp.java.java8;

public class LambdaExpressionExample1 {
    public static void main(String[] args) {

        // With paranthesis, type declarion and curly braces
        GreetingService sayHelloToUser = (String user) -> {
            System.out.println("Hello " + user + "!");
        };

        // With paranthesis, curly braces and without type declarion
        GreetingService sayWelcomeToUser = (user) -> {
            System.out.println("Welcome " + user + "!");
        };

        // With curly braces and without paranthesis, type declarion
        GreetingService sayHiToUser = user -> {
            System.out.println("Hi " + user + "!");
        };

        // Without curly braces, paranthesis, type declarion
        GreetingService sayThankYouToUser = user -> System.out.println("Thank you " + user + "!");

        String user = "Manoj Pawar";
        sayHelloToUser.greet(user);
        sayWelcomeToUser.greet(user);
        sayHiToUser.greet(user);
        sayThankYouToUser.greet(user);
    }

    interface GreetingService {
        void greet(String user);
    }
}