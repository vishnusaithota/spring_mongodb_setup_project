package com.inverntory.project.ecommerce.controller;

import com.inverntory.project.ecommerce.model.Expense;
import com.inverntory.project.ecommerce.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Object> addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @PutMapping
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenceByName(@PathVariable String name){
        Expense result = expenseService.getExpenceByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by/{category}")
    public ResponseEntity<Expense> getExpenseByCategory(@PathVariable String category){
        Expense result = expenseService.getExpenseByCategory(category);
        return ResponseEntity.ok(result);
    }

}
