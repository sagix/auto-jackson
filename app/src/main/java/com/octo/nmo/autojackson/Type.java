package com.octo.nmo.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

enum Type {
    SQUARE("square"),
    CIRCLE("circle");

    private String value;

    Type(final String value) {
        this.value = value;
    }

    @JsonCreator
    static Type parseType(final String value){
        Type type = null;

        for(final Type t : Type.values()){
            if(t.value.equals(value)){
                type = t;
                break;
            }
        }

        return type;
    }

    @JsonValue
    String value() {
        return value;
    }
}
