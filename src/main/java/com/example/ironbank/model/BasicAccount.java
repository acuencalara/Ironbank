package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class BasicAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
