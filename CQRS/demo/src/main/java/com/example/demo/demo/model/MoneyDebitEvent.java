package com.example.demo.demo.model;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class MoneyDebitEvent {
    private final UUID id;
    private final BigDecimal amount;
}
