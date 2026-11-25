package com.alicsan.expense_tracker.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alicsan.expense_tracker.model.Expense;
import com.alicsan.expense_tracker.service.ExpenseService;

class ApiExceptionHandlerTest {

    private ExpenseService expenseService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService(null) {
            @Override
            public Expense createExpense(Expense expense) {
                throw new IllegalArgumentException("Category is required.");
            }
        };
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ExpenseController(expenseService))
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    @Test
    void returnsBadRequestWhenCategoryIsMissing() throws Exception {
        mockMvc.perform(post("/expenses/add")
                        .contentType("application/json")
                        .content("""
                                {
                                  "amount": 12.50,
                                  "category": null
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("""
                        {"error":"Category is required."}
                        """));
    }
}
