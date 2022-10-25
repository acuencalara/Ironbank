package com.example.ironbank.model;

import com.example.ironbank.Enum.StatusEnum;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Data
public class CheckingAccount extends Account {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column =@Column(name="amountMonthlyMaintenanceFee",insertable = false,updatable = false)),
            @AttributeOverride(name="currency",column =@Column(name="currencyMonthlyMaintenanceFee",insertable = false,updatable = false))
    })
    private Money monthlyMaintenanceFee;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount",column =@Column(name="amountMinimumBalance",insertable = false,updatable = false)),
            @AttributeOverride(name="currency",column =@Column(name="currencyMinimumBalance",insertable = false,updatable = false))
    })
    private Money minimumBalance;

    public CheckingAccount() {
    }

}
