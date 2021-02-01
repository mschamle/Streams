package com.schamle.streams.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValueScope {
    Set<String> possibleValues;

    public ValueScope(String[] possibleValues) {
        this.possibleValues = new HashSet<>(Arrays.asList(possibleValues));
    }

    public ValueScope(Set<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public Set<String> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(Set<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public String toString() {
        return possibleValues.toString();
    }
}
