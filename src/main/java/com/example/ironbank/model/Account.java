package com.example.ironbank.model;


import com.example.ironbank.Enum.StatusEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Data
@Entity

public abstract class Account extends BasicAccount {

    protected String secretKey;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private StatusEnum statusEnum;

    public Account() {
    }

    public Account(Money balance, Money penaltyFee, LocalDate creationDate, List<MoneyTransfer> moneyTransfersSend, List<MoneyTransfer> moneyTransfersReceive, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, StatusEnum statusEnum) {
        super(balance, penaltyFee, creationDate, moneyTransfersSend, moneyTransfersReceive, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.statusEnum = statusEnum;
    }

    public Account(LocalDate creationDate, String secretKey, StatusEnum statusEnum) {
        super(creationDate);
        this.secretKey = secretKey;
        this.statusEnum = statusEnum;
    }

    public Account(LocalDate creationDate, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
    }
}
