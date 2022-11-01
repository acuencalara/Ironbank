package com.example.ironbank.service;

import com.example.ironbank.DTO.StudentCheckingAccountDto;
import com.example.ironbank.model.AccountHolder;
import com.example.ironbank.model.StudentCheckingAccount;
import com.example.ironbank.repository.CheckingAccountRepository;
import com.example.ironbank.repository.StudentCheckingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicAccountService {

    private final UserService userService;
    private final CheckingAccountRepository checkingAccountRepository;
    private final StudentCheckingAccountRepository studentCheckingAccountRepository;

    public StudentCheckingAccount postStudentCheckingAccount(StudentCheckingAccountDto studentCheckingAccountDto) {

        StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount();
        studentCheckingAccount.setCreationDate(studentCheckingAccountDto.getCreationDate());
        Optional<AccountHolder> primaryOwnerUserOptional = userService.findAccountHolderByUserId(studentCheckingAccountDto.getPrimaryOwnerUserId());

        studentCheckingAccount.setPrimaryOwner(primaryOwnerUserOptional.get());

        Optional<AccountHolder> secondaryOwnerUserOptional = userService.findAccountHolderByUserId(studentCheckingAccountDto.getPrimaryOwnerUserId());
        if (!secondaryOwnerUserOptional.isEmpty()) {

            studentCheckingAccount.setSecondaryOwner(secondaryOwnerUserOptional.get());
        }

        studentCheckingAccount.setSecretKey(studentCheckingAccountDto.getSecretKey());

        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }

    public List<StudentCheckingAccount> getAllStudentCheckingAccount() {
        return studentCheckingAccountRepository.findAll();
    }

}
