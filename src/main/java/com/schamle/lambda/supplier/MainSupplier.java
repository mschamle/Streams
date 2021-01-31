package com.schamle.lambda.supplier;

import com.schamle.domain.Person;

import java.util.function.Supplier;

/**
 * one of the categories in java.util.function are Suppliers
 *
 * Takes no argument and returns an object
 * public T get();
 */
public class MainSupplier {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
    }
}
