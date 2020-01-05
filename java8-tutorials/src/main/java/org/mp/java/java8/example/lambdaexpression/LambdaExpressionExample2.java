package org.mp.java.java8.example.lambdaexpression;

public class LambdaExpressionExample2 {
    
    public static void main(String[] args) {
        LambdaExpressionExample2 object = new LambdaExpressionExample2();

        // with type declaration
        MathOperation<Integer> addition = (Integer num1, Integer num2) -> num1 + num2;

        // without type declaration
        MathOperation<Integer> substraction = (num1, num2) -> num1 - num2;

        // with type declaration, curly braces and return statement
        MathOperation<Integer> multiplication = (Integer num1, Integer num2) -> {
            return num1 * num2;
        };

        // without type declaration and with curly braces and return statement
        MathOperation<Integer> division = (num1, num2) -> {
            return num1 / num2;
        };

        int input1 = 10;
        int input2 = 5;
        System.out.println("[ " + input1 + " + " + input2 + " ] = " + object.operate(input1, input2, addition));
        System.out.println("[ " + input1 + " - " + input2 + " ] = " + object.operate(input1, input2, substraction));
        System.out.println("[ " + input1 + " * " + input2 + " ] = " + object.operate(input1, input2, multiplication));
        System.out.println("[ " + input1 + " / " + input2 + " ] = " + object.operate(input1, input2, division));

    }

    private <E> E operate(E input1, E input2, MathOperation<E> mathOperation) {
        return (E) mathOperation.operation(input1, input2);
    }

    interface MathOperation<E> {
        E operation(E input1, E input2);
    }
}