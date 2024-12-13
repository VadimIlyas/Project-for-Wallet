package com.javacode.project.dto;

import com.javacode.project.model.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WalletDto {

    private UUID id;

    private BigDecimal balance;

    private OperationType operationType;


}
