package com.example.monopoly.transaction;

import com.example.monopoly.user.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "\"transactions\"")
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long id;
    private BigDecimal Amount;
    private String Description;
    private String OptionalNote;
    private TransactionType TransactionType;
    private LocalDate CreatedAt;
    private LocalDate UpdatedAt;
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Transaction() {

    }

    public Transaction(BigDecimal amount, String description, String optionalNote, com.example.monopoly.transaction.TransactionType transactionType, Long user_id) {
        Amount = amount;
        Description = description;
        OptionalNote = optionalNote;
        TransactionType = transactionType;
        this.user = new User(); // Initialize the user object
        this.user.setId(user_id); // Set the user ID
    }

    public Transaction(Long id, BigDecimal amount, String description, String optionalNote, com.example.monopoly.transaction.TransactionType transactionType, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        Amount = amount;
        Description = description;
        OptionalNote = optionalNote;
        TransactionType = transactionType;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public Long getUserId() {
        return user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOptionalNote() {
        return OptionalNote;
    }

    public void setOptionalNote(String optionalNote) {
        OptionalNote = optionalNote;
    }

    public com.example.monopoly.transaction.TransactionType getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(com.example.monopoly.transaction.TransactionType transactionType) {
        TransactionType = transactionType;
    }

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        UpdatedAt = updatedAt;
    }
}
