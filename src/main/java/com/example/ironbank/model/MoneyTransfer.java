package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime timeStamp;

    @ManyToOne
    private User user;

    @ManyToOne
    private BasicAccount sendAccount;

    @ManyToOne
    private BasicAccount receiveAccount;

    @Embedded
    private Money amount;

}
