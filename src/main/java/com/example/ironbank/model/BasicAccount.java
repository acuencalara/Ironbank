package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="amountBalance", insertable = false, updatable = false)),
            @AttributeOverride(name="currency", column = @Column(name="currencyBalance", insertable = false, updatable = false)),
    })
    private Money balance = new Money(BigDecimal.valueOf(0));

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="amountPenaltyFee", insertable = false, updatable = false)),
            @AttributeOverride(name="currency", column = @Column(name="currencyPenaltyFee", insertable = false, updatable = false)),
    })
    private Money penaltyFee=new Money(BigDecimal.valueOf(40));
    protected LocalDate creationDate;

    @OneToMany(mappedBy = "sendAccount", orphanRemoval = true)
    private List<MoneyTransfer> moneyTransfersSend = new ArrayList<>();

    @OneToMany(mappedBy = "receiveAccount", orphanRemoval = true)
    private List<MoneyTransfer> moneyTransfersReceive = new ArrayList<>();

    @ManyToOne
    private AccountHolder primaryOwner;

    @ManyToOne
    private AccountHolder secondaryOwner;

    public BasicAccount() {
    }

    public BasicAccount(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BasicAccount(Money balance, Money penaltyFee, LocalDate creationDate, List<MoneyTransfer> moneyTransfersSend, List<MoneyTransfer> moneyTransfersReceive, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.balance = balance;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.moneyTransfersSend = moneyTransfersSend;
        this.moneyTransfersReceive = moneyTransfersReceive;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
