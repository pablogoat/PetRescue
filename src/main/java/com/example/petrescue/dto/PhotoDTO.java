package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PhotoDTO(
        String small,
        String medium,
        String large
) {
    public PhotoDTO(@JsonProperty("small") String small,
                    @JsonProperty("medium") String medium,
                    @JsonProperty("large") String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }
}
