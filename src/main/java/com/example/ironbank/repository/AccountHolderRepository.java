package com.example.ironbank.repository;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {


    @Override
    List<AccountHolder> findAll();

    @Query("select a from AccountHolder a where a.userId = ?1")
    Optional<AccountHolder> findByUserId(Long userId);


}
