package com.schamle.lambda.comparator;

import com.schamle.domain.Person;

import java.util.Comparator;

/**
 * First example of using lambdas using Comparators.
 */
public class MainComparator {
    public static void main(String[] args) {
        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cmpLastName = (p1,p2) -> p1.getLastName().compareTo(p2.getLastName());

        //or with method references
        Comparator<Person> cmpAge1 = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpFirstName1 = Comparator.comparing(Person::getFirstName);
        Comparator<Person> cmpLastName1 = Comparator.comparing(Person::getLastName);

        //chaining
        Comparator<Person> compare = cmpAge1.thenComparing(cmpLastName1).thenComparing(cmpFirstName1);

        //skipping the declarations you can do it in one
        Comparator<Person> compareClean = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getLastName)
                .thenComparing(Person::getFirstName);
    }
}
