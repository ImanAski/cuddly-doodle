package com.example.monopoly.user;

import com.example.monopoly.transaction.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.List;

@Entity
@Table(name = "\"users\"")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Email;
    @Transient
    private Integer Age;
    private LocalDate DateOfBirth;
    private String Password;
    private BigDecimal Balance;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public User() {

    }

    public User(Long id, String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, String password, BigDecimal balance) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Email = email;
        DateOfBirth = dateOfBirth;
        this.setPassword(password);
        Balance = balance;
    }

    public User(String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, String password, BigDecimal balance) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Email = email;
        DateOfBirth = dateOfBirth;
        this.setPassword(password);
        Balance = balance;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return Period.between(this.DateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hash = md.digest(password.getBytes());
            Password = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
        Balance = balance;
    }
}
