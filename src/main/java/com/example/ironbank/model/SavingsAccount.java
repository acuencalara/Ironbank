package com.example.ironbank.model;

import com.example.ironbank.Enum.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SavingsAccount extends Account{

    private BigDecimal interestRate;

    public SavingsAccount(LocalDate creationDate, String secretKey, StatusEnum statusEnum, BigDecimal interestRate) {
        super(creationDate, secretKey, statusEnum);
        this.interestRate = interestRate;
    }

    public SavingsAccount() {

    }
}
