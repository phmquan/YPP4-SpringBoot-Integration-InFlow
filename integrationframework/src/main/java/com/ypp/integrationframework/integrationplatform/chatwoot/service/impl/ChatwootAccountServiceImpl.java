package com.ypp.integrationframework.integrationplatform.chatwoot.service.impl;

import com.ypp.integrationframework.integrationplatform.chatwoot.config.ChatwootConfig;
import com.ypp.integrationframework.integrationplatform.chatwoot.dto.AccountDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootAccountService;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatwootAccountServiceImpl implements ChatwootAccountService {
    private final ChatwootConfig chatwootConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public ChatwootAccountServiceImpl(ChatwootConfig chatwootConfig) {
        this.chatwootConfig = chatwootConfig;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        this.restTemplate = new RestTemplate(requestFactory);
    }

    @Override
    public AccountDto getAccountDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api_access_token", chatwootConfig.getAccessToken());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        String url = chatwootConfig.getBaseUrl() + "/accounts/" + chatwootConfig.getAccountId();

        ResponseEntity<AccountDto> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, AccountDto.class);

        return response.getBody();
    }

    @Override
    public AccountDto updateAccount(AccountDto account) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api_access_token", chatwootConfig.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountDto> entity = new HttpEntity<>(account, headers);

        String url = chatwootConfig.getBaseUrl() + "/accounts/" + chatwootConfig.getAccountId();

        ResponseEntity<AccountDto> response =
                restTemplate.exchange(url, HttpMethod.PATCH, entity, AccountDto.class);

        return response.getBody();
    }

}
