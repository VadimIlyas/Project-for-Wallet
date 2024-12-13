package com.javacode.project.exception;

import com.javacode.project.dto.OperationDto;

import java.math.BigDecimal;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(BigDecimal accountBalance, OperationDto operationDto) {
        super("Insufficient balance a wallet with UUID " + operationDto.getWalletId()
        + ".Requared balance: " + operationDto.getAmount() + ", current balance: " + accountBalance);
    }

}
