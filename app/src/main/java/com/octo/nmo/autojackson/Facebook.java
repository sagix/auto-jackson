package com.octo.nmo.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import auto.parcel.AutoParcel;

@AutoParcel
abstract class Facebook implements Social {

    static final String TYPE = "facebook";

    @JsonCreator
    static Facebook newInstance(
            @JsonProperty("post") final String post,
            @JsonProperty("comments") final int comments,
            @JsonProperty("likes") final int likes) {
        return new AutoParcel_Facebook(post, comments, likes);
    }

    @Override
    public String type() {
        return TYPE;
    }

    @JsonProperty("post")
    abstract String post();

    @JsonProperty("comments")
    abstract int comments();

    @JsonProperty("likes")
    abstract int likes();
}
