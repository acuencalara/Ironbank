package com.example.ironbank.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public abstract  class  User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    protected String name;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
