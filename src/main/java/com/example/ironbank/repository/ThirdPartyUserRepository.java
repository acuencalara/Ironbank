package com.example.ironbank.repository;

import com.example.ironbank.model.ThirdPartyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyUserRepository extends JpaRepository<ThirdPartyUser, Long> {
}