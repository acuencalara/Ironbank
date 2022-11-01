package com.example.ironbank.repository;

import com.example.ironbank.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}