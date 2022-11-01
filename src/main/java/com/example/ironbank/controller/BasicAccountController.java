package com.example.ironbank.controller;

import com.example.ironbank.DTO.StudentCheckingAccountDto;
import com.example.ironbank.model.StudentCheckingAccount;
import com.example.ironbank.service.BasicAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasicAccountController {

    private final BasicAccountService basicAccountService;

    @PostMapping("/studentcheckingaccount/")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCheckingAccount postStudentCheckingAccount(@RequestBody StudentCheckingAccountDto studentCheckingAccountDto){
        return basicAccountService.postStudentCheckingAccount(studentCheckingAccountDto);
    }

    @GetMapping("/studentcheckingaccount/")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCheckingAccount> getAllStudentCheckingAccount(){
        return basicAccountService.getAllStudentCheckingAccount();
    }

}
