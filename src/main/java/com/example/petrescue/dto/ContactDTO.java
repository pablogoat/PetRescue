package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ContactDTO(
        String email,
        AddressDTO address
) {
    public ContactDTO(@JsonProperty("email") String email,
                      @JsonProperty("address") AddressDTO address) {
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Email: ")
                .append(email)
                .append(" City: ")
                .append(address.city())
                .append(String.format("<code: %s> ", address.postcode()))
                .append(String.format("Country/state: %s/%s", address.country(), address.state()));

        return  stringBuilder.toString();
    }
}
