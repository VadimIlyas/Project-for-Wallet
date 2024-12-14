package com.javacode.project.util;

import com.javacode.project.dto.WalletDto;
import com.javacode.project.model.Wallet;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;


@Configuration
//@RequiredArgsConstructor
public class WalletMapper {

    private final ModelMapper modelMapper;

    public WalletMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WalletDto walletToDto(Wallet wallet) {
        return modelMapper.map(wallet, WalletDto.class);
    }

    public Wallet dtoToWallet(WalletDto walletDto) {
        return modelMapper.map(walletDto, Wallet.class);
    }
}
