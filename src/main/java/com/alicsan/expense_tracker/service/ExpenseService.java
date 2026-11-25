package com.alicsan.expense_tracker.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alicsan.expense_tracker.model.Expense;
import com.alicsan.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpensebyId(long expenseId) {
    return expenseRepository.findById(expenseId)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Expense with ID: " + expenseId + " not found."
            ));
    }

    public Expense createExpense(Expense newExpense){
        if(newExpense.getAmount() == null || newExpense.getAmount().signum() <= 0){
            throw new IllegalArgumentException("Incorrect amount.");
        }
        if (newExpense.getCategory() == null) {
            throw new IllegalArgumentException("Category is required.");
        }

        if (newExpense.getDescription() != null && newExpense.getDescription().length() > 200) {
            throw new IllegalArgumentException("Description must be 200 characters or fewer.");
        }

        newExpense.setDate(LocalDateTime.now(ZoneId.of("Europe/Berlin")));

        return expenseRepository.save(newExpense);
    }
}
