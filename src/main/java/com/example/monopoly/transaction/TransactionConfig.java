package com.example.monopoly.transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner transactionRunnder(TransactionRepository transactionRepository, TransactionService transactionService) {
        return args -> {
            Transaction tx1 = new Transaction(new BigDecimal("120000"), "some description", "", TransactionType.INCOME, 1L);
            Transaction tx2 = new Transaction(new BigDecimal("350000"), "some description2", "", TransactionType.INCOME, 1L);
            Transaction tx3 = new Transaction(new BigDecimal("260000"), "some description3", "", TransactionType.SPENDING, 1L);

            transactionService.addTransaction(tx1);
            transactionService.addTransaction(tx2);
            transactionService.addTransaction(tx3);
        };
    }
}
