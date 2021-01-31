package com.schamle.lambda;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Method references and Lamdba expressions are functionally (and in terms of bytecode) equivalent
 * - works for static and regular expressions
 */
public class SimpleFunction {
    Integer age;

    public static void main(String[] args) {
        //simple function
        Function<SimpleFunction, Integer> f1 = function -> function.getAge();
        Function<SimpleFunction, Integer> f2 = SimpleFunction::getAge; //infer types

        /** another example **/
        BinaryOperator<Integer> sum = (a,b) -> a+b;

        //or
        BinaryOperator<Integer> sum1 = (a,b) -> Integer.sum(a,b);

        //with method reference
        BinaryOperator<Integer> sum2 = Integer::sum;

        /** Consumer **/
        Consumer<String> printer = s -> System.out.println(s);

        //with method reference
        Consumer<String> printer1 = System.out::println;
    }

    Integer getAge() {
        return age;
    }

}
