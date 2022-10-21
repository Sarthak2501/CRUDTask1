package com.example.demo.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {


    Optional<Account> findAccountByUserName(String userName);
}
