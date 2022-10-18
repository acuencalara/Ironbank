package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
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
        super();
    }
}
