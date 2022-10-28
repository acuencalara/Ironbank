package com.example.ironbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", nullable = false)
    private Long id;
    private String street;
    private Integer streetNumber;
    private Integer flatNumber;
    private String zipCode;
    private String city;
    private String country;

    @OneToMany(mappedBy = "primaryAddress")
    @JsonIgnore
    private List<AccountHolder> accountHolderListPrimaryAddress = new ArrayList<>();

    @OneToMany(mappedBy = "mailingAddress")
    @JsonIgnore
    private List<AccountHolder> accountHolderListMailingAddress = new ArrayList<>();

    public Address() {
    }

    public Address(String street, Integer streetNumber, Integer flatNumber, String zipCode, String city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
}
