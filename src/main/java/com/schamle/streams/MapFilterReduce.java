package com.schamle.streams;

import com.schamle.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple Map-Filter-Reduce use case
 *
 * Problem: Calculate average age of group of
 * people that are over 20
 *
 * Map- Take list of Persons and map to list of Integer.  List still remains same size
 *
 * Filter - Filter out people that are under 21.  Does not change type of collection
 *
 * Reduce   - reduce to an average amount (Aggregation in SQL sense).  This changes object type
 *          - be aware of associative nature of lambda expression for reduction (code will compile, execute and return
 *            result but will give a wrong answer.  One way to tell is different runs giving different results because of
 *            parallelism
 *          - when working over multiple values be aware of what the initial value is (sum or max operation).  This is called
 *            the identity element.  Would be 0 for sum but this might not work for others, example: 0 for max/min if we have negative values.
 */
public class MapFilterReduce {
    public static void main(String[] args) {
        Person p1 = new Person("Bob", "Smith", 24);
        Person p2 = new Person("Jane", "Goodall", 64);
        Person p3 = new Person("Steve", "Martin", 45);
        Person p4 = new Person("Maurice", "Pepin", 71);
        Person p5 = new Person("Eddie", "Beb", 16);

        List<Person> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4, p5));
        double average = people.stream()
                .mapToInt(Person::getAge) //convert to IntStream
                .filter(age -> age > 20) //another new Stream<Integer>, not heavy because Stream contains no data
                .peek(age -> System.out.println("filtered age: " + age))  //not allowed to do forEach() here because it is terminal call and doesn't return Stream<T> so we can't continue
                .average() //method of IntStream
                .orElse(-1);

        System.out.println("average = " + average);
    }
}
