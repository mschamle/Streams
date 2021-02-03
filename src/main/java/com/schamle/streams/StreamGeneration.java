package com.schamle.streams;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Use stream data generators and limit
 */
public class StreamGeneration {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.generate(() -> "one"); //generate infinite list of streams

        System.out.println("***** Generate endless stream of same value *****");
        stringStream
                .limit(5)
                .forEach(System.out::println);

        Stream<String> stringIterate = Stream.iterate("+", s -> s + "+");  //UnaryFunction takes type and returns element of same type

        System.out.println("***** Generate endless stream of modified value *****");
        stringIterate
                .limit(5)
                .forEach(System.out::println);

        System.out.println("***** Generate endless stream of random numbers *****");
        IntStream intStream = ThreadLocalRandom.current().ints();
        intStream
                .limit(5)
                .forEach(System.out::println);
    }
}
