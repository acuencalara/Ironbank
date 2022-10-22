package com.example.ironbank.repository;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {


    @Override
    List<AccountHolder> findAll();
}
