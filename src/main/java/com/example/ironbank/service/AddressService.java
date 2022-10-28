package com.example.ironbank.service;

import com.example.ironbank.model.Address;
import com.example.ironbank.repository.AddressRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

}
