package com.example.ironbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class ThirdPartyUser extends User{

    @NotBlank
    private String hashKey;

    public ThirdPartyUser(String name, String hashKey) {
        super(name);
        this.hashKey = hashKey;
    }

    public ThirdPartyUser(String name, String username, String password, String hashKey) {
        super(name, username, password);
        this.hashKey = hashKey;
    }

    public ThirdPartyUser() {

    }
}
