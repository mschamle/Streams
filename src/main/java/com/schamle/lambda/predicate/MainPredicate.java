package com.schamle.lambda.predicate;

import java.util.function.Predicate;

/**
 * One of the java.util.function categories
 *
 * Takes and object and returns a boolean (used to filteer)
 *
 * public boolean test(T t);
 *
 * BiPredicate<T, U>  public boolean test(T t, U u);
 */
public class MainPredicate {
    public static void main(String[] args) {
        //old
        Predicate<String> p = new Predicate<String>() {
            public boolean test(String s) {
                return s.length() < 20;
            }
        };

        //lambda
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() < 5;

        Predicate<String> p3 = p1.and(p2);
        Predicate<String> p4 = p1.or(p2);

        Predicate<String> p5 = Predicate.isEqual("Yes");

    }
}
