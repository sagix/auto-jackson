package com.octo.nmo.autojackson;

import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import auto.parcel.AutoParcel;

@AutoParcel
abstract class Simple implements Parcelable{
    @JsonCreator
    static Simple newInstance(
            @JsonProperty("id") final int id,
            @JsonProperty("title") final String title) {
        return new AutoParcel_Simple(id, title);
    }

    @JsonProperty("id")
    abstract int id();

    @JsonProperty("title")
    abstract String title();
}
