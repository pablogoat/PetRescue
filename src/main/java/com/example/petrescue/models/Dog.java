package com.example.petrescue.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    private int id;

    private String name;

    private String photo;

    public Dog(){

    }

    public Dog(int id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }
}
