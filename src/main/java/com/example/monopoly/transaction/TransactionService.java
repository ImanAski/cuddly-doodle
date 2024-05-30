package com.example.monopoly.transaction;

import com.example.monopoly.user.User;
import com.example.monopoly.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public List<Transaction> getAllTransactions() {return transactionRepository.findAll();}

    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isEmpty()) {
            throw new IllegalStateException("Transaction not found");
        }
        return optionalTransaction.get();
    }

    public void addTransaction(Transaction transaction) {
//        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getId());
//        if (optionalTransaction.isPresent()) {
//            throw new IllegalStateException("Transaction already exists");
//        }
        Optional<User> optionalUser = userRepository.findById(transaction.getUserId());
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User not found");
        }

        User user = optionalUser.get();
        user.setBalance(transaction.getTransactionType() == TransactionType.INCOME ? user.getBalance().add(transaction.getAmount()) : user.getBalance().subtract(transaction.getAmount()));
        userRepository.save(user);

        transactionRepository.save(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getId());
        if (optionalTransaction.isEmpty()) {
            throw new IllegalStateException("Transaction not found");
        }
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isEmpty()) {
            throw new IllegalStateException("Transaction not found");
        }
        transactionRepository.deleteById(id);
    }
}
