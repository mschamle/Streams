package com.schamle.streams.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Merge values inside multiple sets.
 *
 * This starts with a Set<ValueType> that in turn each have a scope of type Set<String>.  I am trying to merge the scopes
 * and return a single ValueType (for now assume value in ValueType is unimportant).
 *
 *
 */
public class MergeSets {
    public static void main(String[] args) {
        ValueType valueType1 = getValueType("A", "A", "B", "D");
        ValueType valueType2 = getValueType("C", "A", "C");
        ValueType valueType3 = getValueType("E", "E");

        ValueType finalValue = mergeValueTypes (new HashSet<>(Arrays.asList(valueType1,valueType2,valueType3)));
        System.out.println("finalValue = " + finalValue);
    }

private static ValueType getValueType(String value, String ... scope) {
    return new ValueType(value, getValueScope(scope));
}

private static ValueScope getValueScope(String[] scope) {
    return new ValueScope(scope);
}

private static ValueType mergeValueTypes(Set<ValueType> types) {
        Set<ValueScope> scopes = types.stream().map(ValueType::getScope).collect(Collectors.toSet());
        ValueType mergedType = types.iterator().next();
        mergedType.setScope(mergeScopes(scopes));
        return mergedType;
}

private static ValueScope mergeScopes(Set<ValueScope> scopes){
    Set<String> mergedValues = new HashSet<>();
    scopes.forEach(s -> mergedValues.addAll(s.getPossibleValues()));
    System.out.println("mergedValues = " + mergedValues);
    ValueScope mergedValueScope = scopes.iterator().next();
    mergedValueScope.setPossibleValues(mergedValues);
    return mergedValueScope;
}

}
