package com.alicsan.expense_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;

    protected Expense() {
    }

    public Expense(ExpenseCategory category, BigDecimal amount, String description) {
        this.category = category;
        this.amount = amount;
        this.date = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        this.description = description;
    }


    public long getId() {
        return id;
    }


    public ExpenseCategory getCategory() {
        return category;
    }


    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    

    
}
