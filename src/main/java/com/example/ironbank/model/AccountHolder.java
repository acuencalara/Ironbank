package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class AccountHolder extends User {

    private LocalDate dateofBirth;
    private Adress primaryAdress;
    private String emailAdress;


    public AccountHolder() {
        super();
    }
}
