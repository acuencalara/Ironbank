package com.example.ironbank.model;

import com.example.ironbank.Enum.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class StudentCheckingAccount extends Account {
    public StudentCheckingAccount(LocalDate creationDate, String secretKey, StatusEnum statusEnum) {
        super(creationDate, secretKey, statusEnum);
    }

    public StudentCheckingAccount(LocalDate creationDate,  AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(creationDate, primaryOwner, secondaryOwner, secretKey);
    }

    public StudentCheckingAccount() {

    }
}
