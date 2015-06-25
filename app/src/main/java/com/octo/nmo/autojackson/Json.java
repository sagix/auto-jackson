package com.octo.nmo.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import auto.parcel.AutoParcel;

@AutoParcel
abstract class Json {
    @JsonCreator
    static Json newInstance(
            @JsonProperty("simple") final Simple simple,
            @JsonProperty("complex") final Complex complex,
            @JsonProperty("simple-list") final List<Item> list,
            @JsonProperty("complex-typed-list") final List<Social> socialList) {
        return new AutoParcel_Json(simple, complex, list, socialList);
    }

    @JsonProperty("simple")
    abstract Simple simple();

    @JsonProperty("complex")
    abstract Complex complex();

    @JsonProperty("simple-list")
    abstract List<Item> list();

    @JsonProperty("complex-typed-list")
    abstract List<Social> socialList();
}
