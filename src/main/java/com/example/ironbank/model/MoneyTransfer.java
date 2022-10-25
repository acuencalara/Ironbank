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
    @JoinColumn(name = "user_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "send_account_id")
    private BasicAccount sendAccount;

    @ManyToOne
    @JoinColumn(name = "receive_account_id")
    private BasicAccount receiveAccount;

    @Embedded
    private Money amount;

}
