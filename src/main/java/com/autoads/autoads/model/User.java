package com.autoads.autoads.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public class User {

    private final UUID id;
    private UUID adId;

    @NotBlank
    private String name;

    public User(@JsonProperty("id") UUID id,@JsonProperty("adId") UUID adId, @JsonProperty("name") String name) {
        this.id = id;
        this.adId = adId;
        this.name = name;
    }

    public User(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAdId() {
        return adId;
    }

    public String getName() {
        return name;
    }

    public void setAdId(UUID adId) {
        this.adId = adId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
