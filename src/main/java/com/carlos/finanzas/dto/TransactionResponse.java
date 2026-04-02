package com.carlos.finanzas.dto;

import java.time.LocalDate;

public class TransactionResponse {

    private Long id;
    private Double amount;
    private String type;
    private LocalDate date;
    private Long userId;
    private String note;

    public TransactionResponse(
            Long id,
            Double amount,
            String type,
            LocalDate date,
            Long userId,
            String note
    ) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.userId = userId;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNote() {
        return note;
    }
}


