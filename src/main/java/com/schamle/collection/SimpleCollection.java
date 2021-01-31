package com.schamle.collection;

import com.schamle.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleCollection {

    public static void main(String[] args) {
        Person bob = new Person("Bob", "Smith", 24);
        Person jane = new Person("Jane", "Goodall", 64);
        Person steve = new Person("Steve", "Martin", 45);

        //This would not work because list is backed on original array and you can't remove elements from Array
        //List<Person> people =Arrays.asList(bob, jane, steve);

        List<Person> people = new ArrayList<>(Arrays.asList(bob, jane, steve));

        people.forEach(System.out::println);

        people.removeIf(person -> person.getAge() < 30);
        people.replaceAll(person -> new Person(person.getFirstName(), person.getLastName().toUpperCase(), person.getAge()));
        people.sort(Comparator.comparing(Person::getAge));

        System.out.println("**************************************************");
        people.forEach(System.out::println);

    }
}
