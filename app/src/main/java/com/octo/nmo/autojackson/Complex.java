package com.octo.nmo.autojackson;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import auto.parcel.AutoParcel;

@AutoParcel
@JsonDeserialize(builder = AutoParcel_Complex.Builder.class)
abstract class Complex {
    static Builder builder() {
        return new AutoParcel_Complex.Builder();
    }

    @JsonProperty("id")
    abstract Integer id();

    @JsonProperty("title")
    abstract String title();

    @JsonProperty("description")
    abstract String description();

    @JsonProperty("tag")
    abstract String tag();

    @Nullable
    @JsonProperty("image")
    abstract String image();

    @AutoParcel.Builder
    interface Builder {

        @JsonProperty("id")
        Builder id(final Integer id);

        @JsonProperty("title")
        Builder title(final String title);

        @JsonProperty("description")
        Builder description(final String description);

        @JsonProperty("tag")
        Builder tag(final String tag);

        @JsonProperty("image")
        Builder image(final String image);

        Complex build();
    }


}
