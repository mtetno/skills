package com.example.demo.demo.projections;


import com.example.demo.demo.model.AccountCreatedEvent;
import com.example.demo.demo.respository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BankAccountProjections {

    private final BankAccountRepository bankAccountRepository;


    public void on(AccountCreatedEvent event){

    }



}
