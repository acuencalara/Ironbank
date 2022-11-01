package com.example.ironbank.DTO;

import com.example.ironbank.model.StudentCheckingAccount;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link StudentCheckingAccount} entity
 */
@Data
public class StudentCheckingAccountDto implements Serializable {
    private final LocalDate creationDate;
    @NotNull
    private final Long primaryOwnerUserId;
    private final Long secondaryOwnerUserId;
    private final String secretKey;
}