package com.example.demo.Account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository){
        return args -> {
            Account sarthak = new Account(
                    1126L,
                    "Sarthak2501",
                    "Sarthak",
                    "Shashi",
                    6267878L,
                    "Sarthak2501@gmail.com",
                    LocalDate.of(2001, Month.JANUARY,25)
            );

            repository.saveAll(List.of(sarthak));
        };
    }
}
