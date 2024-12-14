package com.javacode.project.dto;

import com.javacode.project.model.Type;

import java.math.BigDecimal;
import java.util.UUID;


//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class WalletDto {

    private UUID id;

    private BigDecimal balance;

    private Type type;


    public WalletDto() {
    }

    public WalletDto(UUID id, BigDecimal balance, Type type) {
        this.id = id;
        this.balance = balance;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
