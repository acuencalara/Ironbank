package com.example.ironbank.controller;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.DTO.AccountHolderDto;
import com.example.ironbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/accountholders/")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder postAccountHolder(@RequestBody AccountHolderDto accountHolder) {
        return userService.postAccountHolder(accountHolder);
    }


}
