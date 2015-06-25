package com.octo.nmo.autojackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = NullSocial.class,
        property = "type"
)
@JsonSubTypes({
        @Type(value = Twitter.class, name = Twitter.TYPE),
        @Type(value = Facebook.class, name = Facebook.TYPE)
})
interface Social {
    // useful for serialisation
    @JsonProperty("type")
    String type();
}
