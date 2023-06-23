package com.example.petrescue.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimalDTO(
        int id,
        String url,
        String age,
        String gender,
        String size,
        String coat,
        String name,
        String description,
        List<PhotoDTO> photos,
        EnvironmentDTO environment,
        ContactDTO contact
) {
    @JsonCreator
    public AnimalDTO(
            @JsonProperty("id") int id,
            @JsonProperty("url") String url,
            @JsonProperty("age") String age,
            @JsonProperty("gender") String gender,
            @JsonProperty("size") String size,
            @JsonProperty("coat") String coat,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("photos") List<PhotoDTO> photos,
            @JsonProperty("environment") EnvironmentDTO environment,
            @JsonProperty("contact") ContactDTO contact
    ) {
        this.id = id;
        this.url = url;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.coat = coat;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.environment = environment;
        this.contact = contact;
    }
}
