package com.javacode.project.repository;

import com.javacode.project.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Query("SELECT w FROM Wallet w WHERE w.id = :id")
    Optional<Wallet> getWalletById(@Param("id") UUID id);


    @Query(value = "SELECT * FROM wallet  WHERE id = :id FOR UPDATE", nativeQuery = true)
    Optional<Wallet> getWalletdByIdWithLock(@Param("id") UUID id);


}
