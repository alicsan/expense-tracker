package com.alicsan.expense_tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alicsan.expense_tracker.model.Expense;
import com.alicsan.expense_tracker.service.ExpenseService;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseByID(@PathVariable long id) {
        return expenseService.getExpensebyId(id);
    }
    
    @PostMapping("/expenses/add")
    public Expense createExpenses(@RequestBody Expense expense) {     
        return expenseService.createExpense(expense);
    }
    
}
