package com.labb2;

import io.micronaut.core.annotation.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import javax.validation.constraints.NotBlank;

@Introspected
@ReflectiveAccess
public class Castle {

    @NonNull
    @NotBlank
    @BsonProperty("name")
    private final String name;

    @Nullable
    @BsonProperty("location")
    private final String location;

    public Castle(@NonNull String name) {
        this(name, null);
    }

    @Creator
    @BsonCreator
    public Castle(@NonNull @BsonProperty("name") String name,
                   @Nullable  @BsonProperty("location") String location) {
        this.name = name;
        this.location = location;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getLocation() {
        return location;
    }
}