package com.inverntory.project.ecommerce;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.inverntory.project.ecommerce.model.Expense;
import com.inverntory.project.ecommerce.model.ExpenseCategory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

	}

}
