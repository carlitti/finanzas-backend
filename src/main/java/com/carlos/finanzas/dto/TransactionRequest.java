package com.carlos.finanzas.dto;

import java.time.LocalDate;

public class TransactionRequest {

    private Double amount;
    private String type;
    private LocalDate date;
   // private Long userId; // De momento no se va a usar
    private String note;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

  /* public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    } */


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
