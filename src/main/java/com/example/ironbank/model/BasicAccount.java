package com.example.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
public abstract class BasicAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate creationDate;

    public BasicAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasicAccount(Long id, LocalDate creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }
}
