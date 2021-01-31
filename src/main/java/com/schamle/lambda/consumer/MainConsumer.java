package com.schamle.lambda.consumer;

import java.util.function.Consumer;

/**
 * one of the categories in java.util.function are Consumers
 *
 * Consumes an object but returns nothing
 * public void accept(T)
 */
public class MainConsumer {

    public static void main(String[] args) {
        Consumer<String> printer = System.out::println;
    }
}
