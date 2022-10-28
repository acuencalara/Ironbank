package com.example.ironbank.controller;

import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.repository.AccountHolderRepository;
import com.example.ironbank.service.AccountHolderService;
import com.example.ironbank.service.InitMasterData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountHolderController {


    @Autowired

    private AccountHolderService accountHolderService;

    @Autowired

    private InitMasterData initMasterData;

    @GetMapping("/initData/")
    public void initData(){
        this.initMasterData.initData();
    }

    @GetMapping("/accountholder/")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAll(){
        return accountHolderService.findAll();
    }



}
