package com.alicsan.expense_tracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.alicsan.expense_tracker.model.Expense;
import com.alicsan.expense_tracker.model.ExpenseCategory;

class ExpenseServiceTest {

    @Test
    void rejectsIncorrectAmount() {
        ExpenseService expenseService = new ExpenseService(null);
        Expense expense = new Expense(
            ExpenseCategory.OTHER,
            new BigDecimal("-45.35"),
            "Free coffee"
        );

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> expenseService.createExpense(expense)
        );

        assertEquals("Incorrect amount.", exception.getMessage());
    }
}
