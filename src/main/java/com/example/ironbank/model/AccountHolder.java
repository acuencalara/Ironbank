package com.example.ironbank.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
public class AccountHolder extends User {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name ="primary_address")
    private Address primaryAddress;

    @ManyToOne
    @JoinColumn(name ="mailing_address")
    private Address mailingAddress;


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
