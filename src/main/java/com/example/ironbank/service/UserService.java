package com.example.ironbank.service;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.DTO.AccountHolderDto;
import com.example.ironbank.model.Address;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final AccountHolderRepository accountHolderRepository;

    private final AddressService addressService;


    public AccountHolder postAccountHolder(AccountHolderDto accountHolderDto) {

        AccountHolder accountHolder = new AccountHolder(accountHolderDto.getName(),
                accountHolderDto.getDateOfBirth());
        accountHolderRepository.save(accountHolder);

        Address primaryAddress = new Address(accountHolderDto.getPrimaryAddressStreet(),
                accountHolderDto.getPrimaryAddressStreetNumber(),
                accountHolderDto.getPrimaryAddressFlatNumber(),
                accountHolderDto.getPrimaryAddressZipCode(),
                accountHolderDto.getPrimaryAddressCity(),
                accountHolderDto.getPrimaryAddressCountry());
        addressService.createAddress(primaryAddress);
        accountHolder.setPrimaryAddress(primaryAddress);

        if (!accountHolderDto.getMailingAddressCity().isEmpty() &&
                !accountHolderDto.getMailingAddressStreet().isEmpty() &&
                !accountHolderDto.getMailingAddressZipCode().isEmpty()&&
        !accountHolderDto.getMailingAddressCountry().isEmpty())
        {
            Address mailingAddress = new Address(accountHolderDto.getMailingAddressStreet(),
                    accountHolderDto.getMailingAddressStreetNumber(),
                    accountHolderDto.getMailingAddressFlatNumber(),
                    accountHolderDto.getMailingAddressZipCode(),
                    accountHolderDto.getMailingAddressCity(),
                    accountHolderDto.getMailingAddressCountry());
            addressService.createAddress(mailingAddress);
            accountHolder.setMailingAddress(mailingAddress);
        }

        return accountHolder;

    }
}
