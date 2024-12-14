package com.javacode.project.dto;

import com.javacode.project.model.OperationType;

import java.math.BigDecimal;
import java.util.UUID;


//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class OperationDto {

    private UUID walletId;

    private BigDecimal amount;

    private OperationType operationType;

    public OperationDto() {
    }

    public OperationDto(UUID walletId, BigDecimal amount, OperationType operationType) {
        this.walletId = walletId;
        this.amount = amount;
        this.operationType = operationType;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
