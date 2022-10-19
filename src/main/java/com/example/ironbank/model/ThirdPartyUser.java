package com.example.ironbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class ThirdPartyUser extends User{

    private String hashKey;

    public ThirdPartyUser(String name, String hashKey) {
        super(name);
        this.hashKey = hashKey;
    }

    public ThirdPartyUser() {

    }
}
