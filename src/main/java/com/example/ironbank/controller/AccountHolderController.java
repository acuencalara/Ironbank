package com.example.ironbank.controller;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @GetMapping("/accountholder/")
    public List<AccountHolder> findAll() {
        return accountHolderService.findAll();
    }

    @PostMapping("/accountholder/")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.addAccountHolder(accountHolder);
    }
}
