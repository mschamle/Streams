package com.schamle.streams.set;

public class ValueType {
    String value;
    ValueScope scope;

    public ValueType(String value, ValueScope scope) {
        this.value = value;
        this.scope = scope;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueScope getScope() {
        return scope;
    }

    public void setScope(ValueScope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "default = " + value + ", scope = " + scope;
    }
}
