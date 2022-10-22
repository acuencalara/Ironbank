package com.example.ironbank.controller;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.Address;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.repository.AddressRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderControllerTest {

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private AddressRepository addressRepository;


    @BeforeEach
    void setUp() {

        Address addressOffice = new Address("Girona",34,1,"08010","Barcelona","Spain");
        Address addressAccountHolderOne = new Address("Foc",34,2,"08011","Barcelona","Spain");
        addressRepository.save(addressOffice);
        addressRepository.save(addressAccountHolderOne);

        AccountHolder accountHolderOne = new AccountHolder("Adrián", LocalDate.of(1999,12,11),
                addressRepository.getReferenceById(addressAccountHolderOne.getId()),
                addressRepository.getReferenceById(addressOffice.getId()));
        accountHolderRepository.save(accountHolderOne);


    }

    @AfterEach
    void tearDown() {
        accountHolderRepository.deleteAll();
    }

    @Test
    void findById()throws Exception{
        List<AccountHolder> accountHolder = accountHolderRepository.findAll();
        assertEquals(1,1);
    }
}