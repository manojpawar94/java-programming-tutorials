package org.mp.java.java8.example.functionalinteface;

/**
 * User define functional interface
 */
public class FunctionalInterfaceExample3 {
    
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Hello My Funcational Interface!");
        myFunctionalInterface.doWork();

        TestFunctionalInteface testFunctionalInteface = () -> System.out.println("Test My Funcational Interface!");
        testFunctionalInteface.print();
    }

    @FunctionalInterface
    interface TestFunctionalInteface {
        public void print();
    }
}
