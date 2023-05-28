package com.inverntory.project.ecommerce.repository;

import com.inverntory.project.ecommerce.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRespository extends MongoRepository<Expense,String> {
    Optional<Expense> findByExpenseName(String name);

    Optional<Expense> findByExpenseCategory(String category);
}
