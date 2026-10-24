package com.alicsan.expense_tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alicsan.expense_tracker.model.Expense;
import com.alicsan.expense_tracker.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@RestController
public class ExpenseController {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }
    

    @PostMapping("/expenses/add")
    public Expense createExpenses(@RequestBody Expense expense) {     
        return expenseRepository.save(expense);
    }
    
}
