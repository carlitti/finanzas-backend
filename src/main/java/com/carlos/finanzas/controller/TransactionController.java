package com.carlos.finanzas.controller;

import com.carlos.finanzas.dto.TransactionRequest;
import com.carlos.finanzas.dto.TransactionResponse;
import com.carlos.finanzas.dto.TransactionSummaryResponse;
import com.carlos.finanzas.entity.Transaction;
import com.carlos.finanzas.service.TransactionService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionResponse createTransaction(
            @RequestBody TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setDate(request.getDate());
        transaction.setNote(request.getNote());

        Transaction savedTransaction =
                transactionService.createTransaction(transaction, 1L);

        return new TransactionResponse (
                savedTransaction.getId(),
                savedTransaction.getAmount(),
                savedTransaction.getType(),
                savedTransaction.getDate(),
                savedTransaction.getUser().getId(),
                savedTransaction.getNote()
        );
    }
    @GetMapping
    public List<TransactionResponse> getAllTransactions() {
        return  transactionService.getAllTransactions();
    }

    @GetMapping("/summary")
    public TransactionSummaryResponse getTransactionSummary() {
        return transactionService.getTransactionSummary();
    }

    @GetMapping("/summary/{userId}")
    public TransactionSummaryResponse getSummaryByUser(
            @PathVariable Long userId
    ) {
        return transactionService.getTransactionSummaryByUser(userId);
    }

}
