package com.example.ironbank.model;

import com.example.ironbank.Enum.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SavingsAccount extends Account{

    private BigDecimal interestRate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column =@Column(name="amountMinimumBalance",insertable = false,updatable = false)),
            @AttributeOverride(name="currency",column =@Column(name="currencyMinimumBalance",insertable = false,updatable = false))
    })
    private Money minimumBalance;

    public SavingsAccount(LocalDate creationDate, String secretKey, StatusEnum statusEnum, BigDecimal interestRate) {
        super(creationDate, secretKey, statusEnum);
        this.interestRate = interestRate;
    }

    public SavingsAccount() {

    }
}
