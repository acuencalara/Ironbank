package com.example.ironbank.service;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.User;
import com.example.ironbank.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
@RequiredArgsConstructor
public class UserService {

private UserRepository userRepository;


}
