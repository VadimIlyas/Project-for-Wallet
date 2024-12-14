package com.javacode.project.dto;

import com.javacode.project.model.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class WalletDto {

    private UUID id;

    private BigDecimal balance;

    private OperationType operationType;


    public WalletDto() {
    }

    public WalletDto(UUID id, BigDecimal balance, OperationType operationType) {
        this.id = id;
        this.balance = balance;
        this.operationType = operationType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
