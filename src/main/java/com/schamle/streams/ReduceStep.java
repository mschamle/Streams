package com.schamle.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Test Reduction
 *  * Reduce   - be aware of associative nature of lambda expression for reduction (code will compile, execute and return
 *  *            result but will give a wrong answer.  One way to tell is different runs giving different results because of
 *  *            parallelism
 *  *          - when working over multiple values be aware of what the initial value is (sum or max operation).  This is called
 *  *            the identity element.  Would be 0 for sum but this might not work for others, example: 0 for max/min if we have negative values.
 */
public class ReduceStep {
    public static void main(String[] args) {
        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
        System.out.println("operation = (i1,i2) -> i1 + i2");
        compareReductions(op);
        System.out.println("*********************************");

        BinaryOperator<Integer> op1 = (i1,i2) -> Integer.max(i1,i2);  //would be non-associative if values passed in are all negative
        System.out.println("operation = (i1,i2) -> Integer.max(i1,i2)");
        compareReductions(op1);
        System.out.println("*********************************");

        BinaryOperator<Integer> op2 = (i1,i2) -> (i1+i2)*(i1+i2);  //non-associative
        System.out.println("operation = (i1,i2) -> (i1+i2)*(i1+i2)");
        compareReductions(op2);
        System.out.println("*********************************");

        BinaryOperator<Integer> op3 = (i1,i2) -> (i1+i2)/2;  // ***** average: non-associative, does not work like this *****
        System.out.println("operation = (i1,i2) -> (i1+i2)/2");
        compareReductions(op3);
        System.out.println("*********************************");
    }

    private static void compareReductions(BinaryOperator<Integer> reduction) {
        List<Integer> ints = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        //sublists to simulate parallel computing
        List<Integer> ints1 = Arrays.asList(0,1,2,3,4);
        List<Integer> ints2 = Arrays.asList(5,6,7,8,9);

        int reductionSimple = reduce(ints, 0, reduction);

        System.out.println("reductionSimple = " + reductionSimple);

        //simulate effect of running on 2 cores in parallel
        int reduction1 = reduce(ints1, 0, reduction);
        int reduction2 = reduce(ints2, 0, reduction);
        int reductionParallel = reduce(Arrays.asList(reduction1, reduction2), 0, reduction);

        System.out.println("reductionParallel = " + reductionParallel);
    }

    private static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction){
        int result = valueIfEmpty; //assign identity element

        for (int value: values) {
            result = reduction.apply(result, value);
        }
        return result;
    }
}
