package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SingleResponseDTO(
        AnimalDTO animal
) {
    public SingleResponseDTO(@JsonProperty("animal") AnimalDTO animal) {
        this.animal = animal;
    }
}
