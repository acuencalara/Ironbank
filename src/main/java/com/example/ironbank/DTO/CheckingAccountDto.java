package com.example.ironbank.DTO;

import com.example.ironbank.model.CheckingAccount;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link CheckingAccount} entity
 */
@Data
public class CheckingAccountDto implements Serializable {
    @NotNull
    private final Long primaryOwnerUserId;
    private final Long secondaryOwnerUserId;
    @NotBlank
    private final String secretKey;
}