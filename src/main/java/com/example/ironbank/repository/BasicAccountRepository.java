package com.example.ironbank.repository;

import com.example.ironbank.model.BasicAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicAccountRepository extends JpaRepository<BasicAccount,Long> {

}
