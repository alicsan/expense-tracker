package com.alicsan.expense_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SavingsGoal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private BigDecimal targetAmount;
    private BigDecimal currentAmount;
    private LocalDate deadLine;

    public SavingsGoal(BigDecimal currentAmount, LocalDate deadLine, BigDecimal targetAmount) {
        this.currentAmount = currentAmount;
        this.deadLine = deadLine;
        this.targetAmount = targetAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }


}
