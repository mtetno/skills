package com.example.demo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent {
    private  UUID id;
    private  BigDecimal initialBalance;
    private  String owner;
}
