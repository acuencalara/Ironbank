package com.example.ironbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class CreditCard extends BasicAccount{

    private BigDecimal interestRateCreditCard;

    public CreditCard(LocalDate creationDate, BigDecimal interestRateCreditCard) {
        super(creationDate);
        this.interestRateCreditCard = interestRateCreditCard;
    }

    public CreditCard() {

    }
}
