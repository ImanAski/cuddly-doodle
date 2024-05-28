package com.example.monopoly.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUser(Long Id) {
        Optional<User> userOptional = userRepository.findById(Id);

        if (userOptional.isEmpty()) {
            throw new IllegalStateException("User does not exist");
        }

        return userOptional.get();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long Id) {
        boolean exists = userRepository.existsById(Id);
        if (!exists) {
            throw new IllegalStateException("User does not exist");
        }
        userRepository.deleteById(Id);
    }
}
