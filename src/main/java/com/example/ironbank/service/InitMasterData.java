package com.example.ironbank.service;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.Address;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.repository.AddressRepository;
import com.example.ironbank.repository.AdminUserRepository;
import com.example.ironbank.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitMasterData {

    private AccountHolderRepository accountHolderRepository;

    private AddressRepository addressRepository;

    private UserRepository userRepository;



    public InitMasterData(AccountHolderRepository accountHolderRepository, AddressRepository addressRepository, UserRepository userRepository) {
        this.accountHolderRepository = accountHolderRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public void initData(){

        accountHolderRepository.deleteAll();
        addressRepository.deleteAll();


        Address addressUser1 = new Address("Plza España",2,2, "25842", "Barcelona", "Spain");
        Address addressUser2 = new Address("Girona",2,2, "25842", "Malgrat de Mar", "Spain");
        Address addressUser3 = new Address("Manuel de Falla",2,2, "25842", "Badalona", "Spain");

        addressRepository.save(addressUser1);
        addressRepository.save(addressUser2);
        addressRepository.save(addressUser3);


        AccountHolder user1 = new AccountHolder("Clark Kent",LocalDate.of(1892,02,02),addressUser1,addressUser3);
        AccountHolder user2 = new AccountHolder("John Jackson",LocalDate.of(1892,02,02),addressUser2,addressUser3);
        AccountHolder user3 = new AccountHolder("Antonio López",LocalDate.of(1892,02,02),addressUser2,addressUser3);

        accountHolderRepository.save(user1);
        accountHolderRepository.save(user2);
        accountHolderRepository.save(user3);


    }
}
