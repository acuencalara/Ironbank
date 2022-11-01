package com.example.ironbank.controller;

import com.example.ironbank.DTO.StudentCheckingAccountDto;
import com.example.ironbank.model.StudentCheckingAccount;
import com.example.ironbank.service.BasicAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicAccountController {

    @Autowired
    private final BasicAccountService basicAccountService;

    @PostMapping("/studentcheckingaccount/")
    @ResponseStatus(HttpStatus.OK)
    public StudentCheckingAccount postStudentCheckingAccount(@RequestBody StudentCheckingAccountDto studentCheckingAccountDto){
        return basicAccountService.postStudentCheckingAccount(studentCheckingAccountDto);
    }

}
