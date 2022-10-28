package com.example.ironbank.DTO;

import com.example.ironbank.model.Address;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final String street;
    private final Integer streetNumber;
    private final Integer flatNumber;
    private final String zipCode;
    private final String city;
    private final String country;
}