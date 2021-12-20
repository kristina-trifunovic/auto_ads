package com.autoads.autoads.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Ad {

    private final UUID id;

    @NotBlank
    private final String name;


    public Ad(@JsonProperty("id") UUID id,
              @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
