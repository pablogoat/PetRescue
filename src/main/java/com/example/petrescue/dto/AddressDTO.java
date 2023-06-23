package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressDTO(
        String city,
        String state,
        String postcode,
        String country
) {
    public AddressDTO(@JsonProperty("city") String city,
                      @JsonProperty("state") String state,
                      @JsonProperty("postcode") String postcode,
                      @JsonProperty("country")String country) {
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }
}
