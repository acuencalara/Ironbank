package com.example.ironbank.service;

import com.example.ironbank.DTO.CheckingAccountDto;
import com.example.ironbank.DTO.StudentCheckingAccountDto;
import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.CheckingAccount;
import com.example.ironbank.model.StudentCheckingAccount;
import com.example.ironbank.model.User;
import com.example.ironbank.repository.CheckingAccountRepository;
import com.example.ironbank.repository.StudentCheckingAccountRepository;
import com.example.ironbank.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicAccountService {

    private final UserService userService;
    private final CheckingAccountRepository checkingAccountRepository;
    private final StudentCheckingAccountRepository studentCheckingAccountRepository;

    public StudentCheckingAccount postStudentCheckingAccount(StudentCheckingAccountDto studentCheckingAccountDto) {

        StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount();

        Optional<AccountHolder> primaryOwnerUserOptional = userService.findAccountHolderByUserId(studentCheckingAccountDto.getPrimaryOwnerUserId());

        if (primaryOwnerUserOptional.isEmpty()) {throw new RuntimeException();}

        studentCheckingAccount.setPrimaryOwner(primaryOwnerUserOptional.get());

        Optional<AccountHolder> secondaryOwnerUserOptional = userService.findAccountHolderByUserId(studentCheckingAccountDto.getPrimaryOwnerUserId());

        if (!secondaryOwnerUserOptional.isEmpty()) {
            studentCheckingAccount.setSecondaryOwner(secondaryOwnerUserOptional.get());
        }

        studentCheckingAccount.setSecretKey(studentCheckingAccountDto.getSecretKey());
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }

}
