package com.javacode.project.exception;

import com.javacode.project.dto.OperationDto;

import java.util.UUID;

public class WalletNotFoundException extends RuntimeException {

    public WalletNotFoundException(String message) {
        super(message);
    }

    public WalletNotFoundException(UUID id) {
        super("Wallet with UUID " + id + " not found.");
    }
}
