package com.inverntory.project.ecommerce.service;

import com.inverntory.project.ecommerce.model.Expense;
import com.inverntory.project.ecommerce.repository.ExpenseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRespository expenseRespository;
    public void addExpense(Expense expense) {
        expenseRespository.insert(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRespository.findAll();
    }

    public void updateExpense(Expense expense){
        Expense savedExpense =  expenseRespository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expense.getId())
                ));
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRespository.save(savedExpense);
    }

    public Expense getExpenceByName(String name) {
        return expenseRespository.findByExpenseName(name).orElseThrow(() -> new RuntimeException("Cannot Find The Expense"));
    }

    public void deleteExpense(String id) {
        expenseRespository.deleteById(id);
    }

    public Expense getExpenseByCategory(String category) {
        return expenseRespository.findByExpenseCategory(category)
                .orElseThrow(() -> new RuntimeException("Cannot Find anything By that category"));
    }
}
