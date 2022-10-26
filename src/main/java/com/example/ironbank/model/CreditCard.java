package com.example.ironbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class CreditCard extends BasicAccount{

    private BigDecimal interestRateCreditCard;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column =@Column(name="amountCreditLimit",insertable = false,updatable = false)),
            @AttributeOverride(name="currency",column =@Column(name="currencyCreditLimit",insertable = false,updatable = false))
    })
    private Money creditLimit;

    public CreditCard(LocalDate creationDate, BigDecimal interestRateCreditCard) {
        super(creationDate);
        this.interestRateCreditCard = interestRateCreditCard;
    }

    public CreditCard() {

    }
}
