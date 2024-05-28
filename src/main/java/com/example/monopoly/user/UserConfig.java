package com.example.monopoly.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User iman = new User("Iman", "Mokhtari Aski", "09934942488", "imaaski@gmail.com", LocalDate.of(2001, Month.AUGUST, 29), "test1");
            User saeed = new User("Saeed", "Amini", "09934942488", "saeed@gmail.com", LocalDate.of(199, Month.AUGUST, 29), "test2");
            User safa = new User("Safa", "Ahmadi", "09934942488", "safa@gmail.com", LocalDate.of(1991, Month.AUGUST, 29), "test3");

            userRepository.saveAll(
                    List.of(iman, saeed, safa)
            );
        };
    }
}
