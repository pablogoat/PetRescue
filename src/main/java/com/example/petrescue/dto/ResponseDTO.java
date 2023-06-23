package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDTO(
        List<AnimalDTO> animals
) {
    @JsonCreator
    public ResponseDTO(@JsonProperty("animals") List<AnimalDTO> animals) {
        this.animals = animals;
    }
}
