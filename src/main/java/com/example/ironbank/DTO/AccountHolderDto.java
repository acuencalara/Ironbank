package com.example.ironbank.DTO;

import com.example.ironbank.model.AccountHolder;
import com.sun.istack.NotNull;
import lombok.*;

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

    @NotEmpty
    private final String name;
    @NotEmpty
    private final LocalDate dateOfBirth;

    @NotEmpty
    private final String primaryAddressStreet;
    @NotEmpty
    private final Integer primaryAddressStreetNumber;
    @NotEmpty
    private final Integer primaryAddressFlatNumber;
    @NotEmpty
    private final String primaryAddressZipCode;
    @NotEmpty
    private final String primaryAddressCity;
    @NotEmpty
    private final String primaryAddressCountry;

    private final String mailingAddressStreet;
    private final Integer mailingAddressStreetNumber;
    private final Integer mailingAddressFlatNumber;
    private final String mailingAddressZipCode;
    private final String mailingAddressCity;
    private final String mailingAddressCountry;


}