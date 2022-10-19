package com.example.ironbank.model;


import com.example.ironbank.Enum.StatusEnum;
import lombok.AllArgsConstructor;
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
public abstract class Account extends BasicAccount{

    private String secretkey;

    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    private StatusEnum statusEnum;

    public Account(){

    }
}
