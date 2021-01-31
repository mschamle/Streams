package com.schamle.streams;

/**
 * Simple Map-Filte-Reduce use case
 *
 * Problem: Calculate average age of grroup of
 * people that are over 20
 *
 * Map- Take list of Persons and map to list of Integer.  List still remains same size
 *
 * Filter - Filter out people that are under 21.  Does not change type of collection
 *
 * Reduce - reduce to an average amount (Aggregation in SQL sense).  This changes object type
 *
 * Caveats - be aware of associative nature of lambda expression for reduction (code will compile, execute and return
 *          result but will give a wrong answer.  One way to tell is different runs giving different results because of
 *          parallelism
 */
public class MapFilterReduce {
}
