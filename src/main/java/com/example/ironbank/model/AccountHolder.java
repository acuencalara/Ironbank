package com.example.ironbank.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class AccountHolder extends User {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @ManyToOne
    private Address primaryAddress;

    @ManyToOne
    private Address mailingAddress;


    @OneToMany(mappedBy = "primaryOwner", orphanRemoval = true)
    private List<BasicAccount> basicAccountsPrimaryOwner = new ArrayList<>();

    @OneToMany(mappedBy = "secondaryOwner", orphanRemoval = true)
    private List<BasicAccount> basicAccountsSecondaryOwner = new ArrayList<>();

    public AccountHolder() {
    }

    public AccountHolder(LocalDate dateOfBirth, Address primaryAddress, Address mailingAddress) {
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder(String name, LocalDate dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }
}
