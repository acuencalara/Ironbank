package com.example.ironbank.service;

import com.example.ironbank.DTO.AccountHolderDto;
import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.Address;
import com.example.ironbank.model.AdminUser;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.repository.AdminUserRepository;
import com.example.ironbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AccountHolderRepository accountHolderRepository;
    private final AddressService addressService;

    private final AdminUserRepository adminUserRepository;


    public AccountHolder postAccountHolder(AccountHolderDto accountHolderDto) {

        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setName(accountHolderDto.getName());
        accountHolder.setDateOfBirth(accountHolderDto.getDateOfBirth());

        Address primaryAddress = new Address(accountHolderDto.getPrimaryAddressStreet(),
                accountHolderDto.getPrimaryAddressStreetNumber(),
                accountHolderDto.getPrimaryAddressFlatNumber(),
                accountHolderDto.getPrimaryAddressZipCode(),
                accountHolderDto.getPrimaryAddressCity(),
                accountHolderDto.getPrimaryAddressCountry());
        addressService.createAddress(primaryAddress);
        accountHolder.setPrimaryAddress(primaryAddress);

        if ((accountHolderDto.getMailingAddressCity()!=null&&!accountHolderDto.getMailingAddressCity().isBlank()) &&
                (accountHolderDto.getMailingAddressStreet()!=null&&!accountHolderDto.getMailingAddressStreet().isBlank()) &&
                (accountHolderDto.getMailingAddressZipCode()!=null&&!accountHolderDto.getMailingAddressZipCode().isBlank()) &&
                (accountHolderDto.getMailingAddressCountry()!=null&&!accountHolderDto.getMailingAddressCountry().isBlank())) {
            Address mailingAddress = new Address(accountHolderDto.getMailingAddressStreet(),
                    accountHolderDto.getMailingAddressStreetNumber(),
                    accountHolderDto.getMailingAddressFlatNumber(),
                    accountHolderDto.getMailingAddressZipCode(),
                    accountHolderDto.getMailingAddressCity(),
                    accountHolderDto.getMailingAddressCountry());
            addressService.createAddress(mailingAddress);
            accountHolder.setMailingAddress(mailingAddress);
        }
        return accountHolderRepository.save(accountHolder);
    }

    public AdminUser postAdminUser(AdminUser adminUser){
        AdminUser adminUser1=new AdminUser();
        if(!adminUser.getName().isBlank()&&adminUser.getName()!=null){
            adminUser1.setName(adminUser.getName());
            adminUserRepository.save(adminUser1);
        }
        return adminUser1;
    }
}
