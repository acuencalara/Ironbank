package com.example.ironbank.model;


import com.example.ironbank.Enum.StatusEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Setter
@Getter
@Data
@Entity
public abstract class Account extends BasicAccount {

    private String secretKey;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private StatusEnum statusEnum;

    public Account() {
    }

    public Account(LocalDate creationDate, String secretKey, StatusEnum statusEnum) {
        super(creationDate);
        this.secretKey = secretKey;
        this.statusEnum = statusEnum;
    }
}
