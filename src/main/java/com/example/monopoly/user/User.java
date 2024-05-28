package com.example.monopoly.user;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
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

    public User() {

    }

    public User(Long id, String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, String password) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Email = email;
        DateOfBirth = dateOfBirth;
        Password = password;
    }

    public User(String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, String password) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Email = email;
        DateOfBirth = dateOfBirth;
        Password = password;
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
        org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder =
                new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        Password = encoder.encode(password);
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
}
