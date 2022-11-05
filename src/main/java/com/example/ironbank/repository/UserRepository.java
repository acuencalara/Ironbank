package com.example.ironbank.repository;

import com.example.ironbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.id = ?1")
    User findByUserId(Long id);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);



}
