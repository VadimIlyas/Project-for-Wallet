package com.javacode.project.service;


import com.javacode.project.dto.OperationDto;
import com.javacode.project.dto.WalletDto;

import java.util.UUID;


public interface WalletService {

    WalletDto getWallet(UUID id);

    void updateWallet(OperationDto operationDto);
}
