package com.example.demo.demo.exception;

import java.math.BigDecimal;
import java.util.UUID;

public class InsuffientBalanceException extends Throwable{

    public InsuffientBalanceException(UUID id, BigDecimal amount) {
        super("Insuffient balanace: Cannot debit "+amount+ "from account "+ id);
    }
}
