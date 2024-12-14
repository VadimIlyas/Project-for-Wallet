package com.javacode.project.controller;


import com.javacode.project.dto.OperationDto;
import com.javacode.project.dto.WalletDto;
import com.javacode.project.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<WalletDto> findWallet(@PathVariable String WALLET_UUID) {
        WalletDto walletDto = walletService.getWallet(UUID.fromString(WALLET_UUID));
        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }

    @PostMapping("/wallet")
    public ResponseEntity<Void> updateWallet(@RequestBody OperationDto operationDto) {
        walletService.updateWallet(operationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
