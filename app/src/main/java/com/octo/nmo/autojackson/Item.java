package com.octo.nmo.autojackson;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import auto.parcel.AutoParcel;

@AutoParcel
abstract class Item {
    @JsonCreator
    static Item newInstance(
            @JsonProperty("id") final int id,
            @JsonProperty("type") final Type type) {
        return new AutoParcel_Item(id, type);
    }

    @JsonProperty("id")
    abstract int id();

    @Nullable
    @JsonProperty("type")
    abstract Type type();
}
