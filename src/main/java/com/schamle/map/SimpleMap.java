package com.schamle.map;

import com.schamle.domain.Person;

import java.util.*;

public class SimpleMap {
    public static void main(String[] args) {

        Map<String, List<Person>> map = initMap();

        map.forEach((city, list) -> System.out.println(city + ": " + list.size() + " people"));  //uses BiConsumer

        //new method prevents null return
        System.out.println("Boston people: " + map.getOrDefault("Boston", Collections.emptyList()));

        //replace method now has a second version that only replaces if value matches
        System.out.println("London People = " + map.getOrDefault("London", Collections.emptyList()).toString());
        map.replace("London", getParisPeople(), getParisPeople());
        System.out.println("Tried to replace London People with wrong existing value = " + map.getOrDefault("London", Collections.emptyList()).toString());

        //note below doesn't work because equals on List doesn't
        map.replace("London", getLondonPeople(), getParisPeople());
        System.out.println("Tried to replace London People with right existing value = " + map.getOrDefault("London", Collections.emptyList()).toString());

        //example of computeIfAbsent to add (not computeIfAbsent() also returns list and you can add person)
        map.computeIfAbsent("Boston", key -> new ArrayList<Person>()).add(new Person("Betsy", "Ross", 26));
        System.out.println("Boston people: " + map.getOrDefault("Boston", Collections.emptyList()));
        map.forEach((city, list) -> System.out.println(city + ": " + list.size() + " people"));  //uses BiConsumer
    }

    private static Map<String, List<Person>> initMap() {
        Map<String, List<Person>> map = new HashMap<>();
        map.computeIfAbsent("London", city -> new ArrayList<Person>()).addAll(getLondonPeople());
        map.computeIfAbsent("Paris", city -> new ArrayList<Person>()).addAll(getParisPeople());
        return map;
    }

    private static List<Person> getLondonPeople() {
        Person bob = new Person("Bob", "Smith", 24);
        Person jane = new Person("Jane", "Goodall", 64);
        return new ArrayList<>(List.of(bob, jane));
    }

    private static List<Person> getParisPeople() {
        Person steve = new Person("Steve", "Martin", 45);
        Person maurice = new Person("Maurice", "Pepin", 71);
        return new ArrayList<>(List.of(steve, maurice));
    }
}
