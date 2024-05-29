package com.example.monopoly.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions() { return transactionService.getAllTransactions(); }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) { return transactionService.getTransactionById(id); }

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction) { transactionService.addTransaction(transaction); }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) { transactionService.deleteTransaction(id); }
}
