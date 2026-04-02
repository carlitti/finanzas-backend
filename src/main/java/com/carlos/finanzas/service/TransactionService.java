package com.carlos.finanzas.service;

import com.carlos.finanzas.dto.TransactionResponse;
import com.carlos.finanzas.dto.TransactionSummaryResponse;
import com.carlos.finanzas.entity.Transaction;
import com.carlos.finanzas.entity.User;
import com.carlos.finanzas.repository.TransactionRepository;
import com.carlos.finanzas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public TransactionService(
            TransactionRepository transactionRepository, UserService userService,
            UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Transaction createTransaction(
            Transaction transaction,
            Long userId
    ) {
        User user = userRepository.findById(1L).orElseGet(() -> {
            User dev = new User();
            dev.setUsername("dev");
            return userRepository.save(dev);
        });


        transaction.setUser(user);

        return transactionRepository.save(transaction);
    }

    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transaction -> new TransactionResponse(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getType(),
                        transaction.getDate(),
                        transaction.getUser().getId(),
                        transaction.getNote()
                ))
                .toList();
    }

    public TransactionSummaryResponse getTransactionSummary() {

        double totalIncome = transactionRepository.findAll()
                .stream()
                .filter(transaction -> "INCOME".equals(transaction.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactionRepository.findAll()
                .stream()
                .filter(transaction -> "EXPENSE".equals(transaction.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double balance = totalIncome - totalExpense;

        return new TransactionSummaryResponse(
                null,
                totalIncome,
                totalExpense,
                balance
        );
    }
    public TransactionSummaryResponse getTransactionSummaryByUser(Long userId) {

        double totalIncome = transactionRepository.findAll()
                .stream()
                .filter(t -> t.getUser().getId().equals(userId))
                .filter(t -> "INCOME".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactionRepository.findAll()
                .stream()
                .filter(t -> t.getUser().getId().equals(userId))
                .filter(t -> "EXPENSE".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double balance = totalIncome - totalExpense;

        return new TransactionSummaryResponse(
                userId,
                totalIncome,
                totalExpense,
                balance
        );
    }

}
