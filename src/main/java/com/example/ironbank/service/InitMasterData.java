package com.example.ironbank.service;

import com.example.ironbank.Enum.StatusEnum;
import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.Address;
import com.example.ironbank.model.StudentCheckingAccount;
import com.example.ironbank.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InitMasterData {

    private final AccountHolderRepository accountHolderRepository;
    private final AddressRepository addressRepository;

    private final UserRepository userRepository;

    private final ThirdPartyUserRepository thirdPartyUserRepository;

    private RoleRepository roleRepository;
    private final StudentCheckingAccountRepository studentCheckingAccountRepository;

    public void initData(){

        studentCheckingAccountRepository.deleteAll();
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

        StudentCheckingAccount studentCheckingAccount1 = new StudentCheckingAccount( LocalDate.of(1999,12,11),user1,user2,"IwonApollo");
        studentCheckingAccountRepository.save(studentCheckingAccount1);

    }
}
