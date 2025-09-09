package com.ypp.integrationframework.integrationplatform.chatwoot.service;

import com.ypp.integrationframework.integrationplatform.chatwoot.dto.AccountDto;

public interface ChatwootAccountService {
    AccountDto getAccountDetails();

    AccountDto updateAccount(AccountDto account);
}
