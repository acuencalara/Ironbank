package com.example.ironbank.DTO;

import com.example.ironbank.Enum.StatusEnum;
import com.example.ironbank.model.StudentCheckingAccount;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link StudentCheckingAccount} entity
 */
@Data
public class StudentCheckingAccountDto implements Serializable {

    @NotNull
    private final Long primaryOwnerUserId;
    private final Long secondaryOwnerUserId;
    @NotBlank
    private final String secretKey;

}