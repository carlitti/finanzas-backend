package com.carlos.finanzas.dto;

public class TransactionSummaryResponse {

    private Long userId;
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;

    public TransactionSummaryResponse(
            Long userId,
            Double totalIncome,
            Double totalExpense,
            Double balance
    ) {
        this.userId = userId;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public Double getBalance() {
        return balance;
    }
}
