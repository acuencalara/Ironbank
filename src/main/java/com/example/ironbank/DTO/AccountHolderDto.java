package com.example.ironbank.DTO;

import com.example.ironbank.model.AccountHolder;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link AccountHolder} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class AccountHolderDto implements Serializable {

    @NotBlank
    private final String name;
    @NotBlank
    private final LocalDate dateOfBirth;

    @NotBlank
    private final String primaryAddressStreet;
    @NotBlank
    private final Integer primaryAddressStreetNumber;
    @NotBlank
    private final Integer primaryAddressFlatNumber;
    @NotBlank
    private final String primaryAddressZipCode;
    @NotBlank
    private final String primaryAddressCity;
    @NotBlank
    private final String primaryAddressCountry;

    private final String mailingAddressStreet;
    private final Integer mailingAddressStreetNumber;
    private final Integer mailingAddressFlatNumber;
    private final String mailingAddressZipCode;
    private final String mailingAddressCity;
    private final String mailingAddressCountry;

}