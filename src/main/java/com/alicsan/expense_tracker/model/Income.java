package com.alicsan.expense_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String source;
    private BigDecimal amount;
    private LocalDate date;

    public Income(BigDecimal amount, LocalDate date, String source) {
        this.amount = amount;
        this.date = date;
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
