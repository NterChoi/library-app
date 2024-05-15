package com.group.libraryapp.ex.fruitstore.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellInfoRequest {
    @JsonProperty("id")
    private final long id;

    public SellInfoRequest( @JsonProperty("id") long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
