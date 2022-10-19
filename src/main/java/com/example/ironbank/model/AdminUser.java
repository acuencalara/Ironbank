package com.example.ironbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
    }

    public AdminUser() {

    }
}
