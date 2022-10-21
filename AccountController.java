package com.example.demo.Account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccount(){
        return accountService.getAccount();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Account account){
        accountService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") long accountId){
        accountService.deleteAccount(accountId);
    }

    @PutMapping(path = "{accountId}")
    public void updateStudent(@PathVariable long accountId,@RequestParam(required = false) String userName,
                              @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String email){
        accountService.updateAccount(accountId,userName,firstName,lastName,email);
    }
}
