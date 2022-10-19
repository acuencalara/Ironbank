package com.example.ironbank.model;

import com.example.ironbank.Enum.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Data
public class CheckingAccount extends Account {

    public CheckingAccount() {
    }

    public CheckingAccount(LocalDate creationDate, String secretKey, StatusEnum statusEnum) {
        super(creationDate, secretKey, statusEnum);
    }
}
