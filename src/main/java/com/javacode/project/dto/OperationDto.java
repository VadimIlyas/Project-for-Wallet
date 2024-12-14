package com.javacode.project.dto;

import com.javacode.project.model.Type;

import java.math.BigDecimal;
import java.util.UUID;


//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class OperationDto {

    private UUID walletId;

    private BigDecimal amount;

    private Type type;

    public OperationDto() {
    }

    public OperationDto(UUID walletId, BigDecimal amount, Type operationType) {
        this.walletId = walletId;
        this.amount = amount;
        this.type = operationType;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
