package com.alicsan.expense_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private final long id;
    private Category category;
    private BigDecimal amount;
    private LocalDate date;
    private String description;


    public Expense(long id, Category category, BigDecimal amount, LocalDate date, String description) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }


    public long getId() {
        return id;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
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


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    

    
}
