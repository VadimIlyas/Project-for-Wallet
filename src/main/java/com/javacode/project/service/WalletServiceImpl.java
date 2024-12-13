package com.javacode.project.service;

import com.javacode.project.dto.OperationDto;
import com.javacode.project.dto.WalletDto;
import com.javacode.project.exception.InsufficientBalanceException;
import com.javacode.project.exception.InvalidOperationTypeException;
import com.javacode.project.exception.WalletNotFoundException;
import com.javacode.project.model.OperationType;
import com.javacode.project.model.Wallet;
import com.javacode.project.repository.WalletRepository;
import com.javacode.project.util.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {


    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;

    @Override
    public WalletDto getWallet(UUID id) {
        return walletMapper.walletToDto(walletRepository.getWalletById(id).orElse(null));
    }

    @Override
    public void updateWallet(OperationDto operationDto) {
        Wallet wallet = walletRepository.getWalletdByIdWithLock(operationDto.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException(operationDto.getWalletId()));
        BigDecimal currentBalance = wallet.getBalance();
        OperationType type = operationDto.getOperationType();
        BigDecimal newBalance;
        switch (type) {
            case DEPOSIT -> newBalance = currentBalance.add(operationDto.getAmount());
            case WITHDRAW -> {
                checkBalance(currentBalance, operationDto);
                newBalance = currentBalance.subtract(operationDto.getAmount());
            }
            default -> throw new InvalidOperationTypeException(operationDto);
        }
        wallet.setBalance(newBalance);
        walletRepository.save(wallet);
    }

    private void checkBalance(BigDecimal currentBalance, OperationDto operationDto) {
        if (currentBalance.compareTo(operationDto.getAmount()) < 0) {
            throw new InsufficientBalanceException(currentBalance, operationDto);
        }
    }
}
