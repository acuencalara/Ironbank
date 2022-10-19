package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Data
public class CheckingAccount extends Account {

    public CheckingAccount() {
    }
}
