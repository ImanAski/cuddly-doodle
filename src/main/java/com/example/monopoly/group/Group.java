package com.example.monopoly.group;

import com.example.monopoly.transaction.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Group {
    @Id
    private Long id;
    private String Name;
    private String Description;
    @ManyToMany
    private List<Transaction> transactions;

    public Group() {
    }

    public Group(Long id, String name, String description) {
        this.id = id;
        Name = name;
        Description = description;
    }

    public Group(String name, String description) {
        Name = name;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
