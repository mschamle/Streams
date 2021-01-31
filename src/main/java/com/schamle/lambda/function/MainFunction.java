package com.schamle.lambda.function;

import com.schamle.domain.Person;

import java.util.function.Function;

/**
 * category of java.util.function is Functions
 *
 * Does a mapping of one (or more) object(s) to another
 *
 * public R apply(T);
 *
 * For a BiFunction: public R apply (T t, V v)
 *
 * Extension of function is UnaryOperator<T> extends Function<T,T>
 */
public class MainFunction {
    public static void main(String[] args) {
        Function<Person, Integer> ageMapper = Person::getAge;
    }
}
