package com.javacode.project.service;

import com.javacode.project.dto.OperationDto;
import com.javacode.project.dto.WalletDto;
import com.javacode.project.exception.InsufficientBalanceException;
import com.javacode.project.exception.InvalidOperationTypeException;
import com.javacode.project.exception.WalletNotFoundException;
import com.javacode.project.model.Type;
import com.javacode.project.model.Wallet;
import com.javacode.project.repository.WalletRepository;
import com.javacode.project.util.WalletMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;


@Service
@Transactional
public class WalletServiceImpl implements WalletService {


    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletMapper walletMapper, WalletRepository walletRepository) {
        this.walletMapper = walletMapper;
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletDto getWallet(UUID id) {
        OperationDto operationDto = new OperationDto();
        return walletMapper.walletToDto(walletRepository.getWalletById(id).orElseThrow(() -> new WalletNotFoundException(operationDto.getWalletId())));
    }

    @Override
    @Transactional
    public void updateWallet(OperationDto operationDto) {
        Wallet wallet = walletRepository.getWalletdByIdWithLock(operationDto.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException(operationDto.getWalletId()));
        BigDecimal currentBalance = wallet.getBalance();
        Type type = operationDto.getType();
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
