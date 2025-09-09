package com.ypp.integrationframework.integrationplatform.chatwoot.controller;

import com.ypp.integrationframework.integrationplatform.chatwoot.dto.AccountDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/integration/chatwoot")
public class AccountController {
    private final ChatwootAccountService accountService;

    @Autowired
    public AccountController(ChatwootAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/details")
    public AccountDto getAccountDetails() {
        return accountService.getAccountDetails();
    }

    @PatchMapping("/account/update")
    public AccountDto updateAccount(@RequestBody AccountDto account) {
        return accountService.updateAccount(account);
    }
}
