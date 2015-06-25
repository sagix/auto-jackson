package com.octo.nmo.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import auto.parcel.AutoParcel;

@AutoParcel
abstract class Twitter implements Social {
    static final String TYPE = "twitter";

    @JsonCreator
    static Twitter newInstance(
            @JsonProperty("tweet") final String tweet,
            @JsonProperty("author") final String author) {
        return new AutoParcel_Twitter(tweet, author);
    }

    @Override
    public String type() {
        return TYPE;
    }

    @JsonProperty("tweet")
    abstract String tweet();

    @JsonProperty("author")
    abstract String author();
}
