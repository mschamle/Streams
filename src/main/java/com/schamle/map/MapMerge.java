package com.schamle.map;

import com.schamle.domain.Person;

import java.util.*;

/**
 * V merge(K key, V value,
 *             BiFunction<? super V, ? super V, ? extends V> remappingFunction)
 * if passed key is not in map it adds key/value pair to map
 * if passed key is in the map
 *  - merge the existing value with the passed value from the lambda function
 *  - note that remapping takes a pair of values and returns a new value
 */
public class MapMerge {
    public static void main(String[] args) {
        Person p1 = new Person("Bob", "Smith", 24);
        Person p2 = new Person("Jane", "Goodall", 64);
        Person p3 = new Person("Steve", "Martin", 45);
        Person p4 = new Person("Maurice", "Pepin", 71);

        Map<String, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent("London", city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent("Paris", city -> new ArrayList<>()).add(p2);
        System.out.println("*********** Map 1 ************");
        map1.forEach((city, people) -> System.out.println(city + ": " + people));  //uses BiConsumer

        Map<String, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent("Paris", city -> new ArrayList<>()).add(p3);
        map2.computeIfAbsent("New York", city -> new ArrayList<>()).add(p4);
        System.out.println("*********** Map 2 ************");
        map2.forEach((city, people) -> System.out.println(city + ": " + people));  //uses BiConsumer

        //add all people for each city in map2 to same city in map1
        map2.forEach(
                (city, people) -> //BiConsumer: key, value from map2
                        map1.merge(
                                city, people,  //same key, value
                                (peopleFromMap1, peopleFromMap2) -> { //BiFunction (existing, new)
                                    peopleFromMap1.addAll(peopleFromMap2);
                                    return peopleFromMap1;
                                }
                        )
        );

        //result is in map1
        System.out.println("*********** Result in Map 1************");
        map1.forEach((city, people) -> System.out.println(city + ": " + people));  //uses BiConsumer

    }
}
