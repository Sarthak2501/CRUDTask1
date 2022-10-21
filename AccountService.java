package com.example.demo.Account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountOptional = accountRepository.findAccountByUserName(account.getUserName());


        if (accountOptional.isPresent()){
            throw new IllegalStateException("User Name Taken");
        }
        accountRepository.save(account);
    }

    public void deleteAccount(long accountId) {
        Boolean exists = accountRepository.existsById(accountId);

        if (!exists){
            throw new IllegalStateException("account with ID "+ accountId + "sdoes not exist");
        }
        accountRepository.deleteById(accountId);
    }

    public void updateAccount(long accountId, String userName, String firstName, String lastName, String email) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalStateException("account with Id " + accountId + " does not exist"));

        if (userName != null && userName.length() > 0 && !Objects.equals(account.getUserName(),userName)){
            account.setUserName(userName);
        }

        if (firstName != null && firstName.length() > 0 && !Objects.equals(account.getFirstName(),firstName)){
            account.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(account.getLastName(),lastName)){
            account.setLastName(lastName);
        }

        if(email != null && email.length() > 0 && !Objects.equals(account.getEmail(),email)){
            Optional<Account> accountOptional = accountRepository.findAccountByUserName(email);
            if(accountOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            account.setEmail(email);
        }
    }
}
