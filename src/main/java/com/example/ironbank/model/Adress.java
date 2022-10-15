package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Adress {
    private String street;
    private int streetNumber;
    private int flatNumber;
    private String zipCode;
    private String city;
    private String country;



}
