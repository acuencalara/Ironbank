package com.example.ironbank.controller;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.DTO.AccountHolderDto;
import com.example.ironbank.model.AdminUser;
import com.example.ironbank.model.ThirdPartyUser;
import com.example.ironbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/accountholders/")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public AccountHolder postAccountHolder(@RequestBody AccountHolderDto accountHolder) {
        return userService.postAccountHolder(accountHolder);
    }

    @PostMapping("/adminusers/")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUser postAdminUser(@RequestBody AdminUser adminUser){
        return userService.postAdminUser(adminUser);
    }

    @PostMapping("/thirdpartyusers/")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdPartyUser postThirdPartyUser(@RequestBody ThirdPartyUser thirdPartyUser){
        return userService.postThirdPartyUser(thirdPartyUser);
    }


}
