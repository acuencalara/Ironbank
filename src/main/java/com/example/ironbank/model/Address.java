package com.example.ironbank.model;

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

    @OneToMany
    @JoinColumn (name="accountholder_primary_address_id")
    List<AccountHolder> accountHolderListPrimaryAddress=new ArrayList<>();

    @OneToMany
    @JoinColumn (name="accountholder_mailing_address_id")
    List<AccountHolder> accountHolderListMailingAddress=new ArrayList<>();

    public Address() {

    }
}
