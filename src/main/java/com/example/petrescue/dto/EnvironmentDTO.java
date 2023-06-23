package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EnvironmentDTO(
        boolean children,
        boolean dogs,
        boolean cats
) {
    public EnvironmentDTO(@JsonProperty("children") boolean children,
                          @JsonProperty("dogs") boolean dogs,
                          @JsonProperty("cats") boolean cats) {
        this.children = children;
        this.dogs = dogs;
        this.cats = cats;
    }

    // kogo unikac
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!children) {
            stringBuilder.append("Children ");
        }
        if (!dogs) {
            stringBuilder.append("Dogs ");
        }
        if (!cats) {
            stringBuilder.append("Cats");
        }

        if(stringBuilder.isEmpty()) {
            stringBuilder.append("no worries");
        }

        return stringBuilder.toString();
    }
}
