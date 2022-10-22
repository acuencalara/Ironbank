package com.example.ironbank.service;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.Address;
import com.example.ironbank.model.User;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountHolderService {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }

    public AccountHolder addAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

}
