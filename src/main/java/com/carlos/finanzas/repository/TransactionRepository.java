package com.carlos.finanzas.repository;

import com.carlos.finanzas.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
