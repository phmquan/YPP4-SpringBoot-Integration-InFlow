package com.ypp.integrationframework.integrationplatform.chatwoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatwootConfig {
    @Value("${chatwoot.accessToken}")
    private String accessToken;

    @Value("${chatwoot.baseUrl}")
    private String baseUrl;

    @Value("${chatwoot.accountId}")
    private String accountId;

    public String getAccessToken() {
        return accessToken;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAccountId() {
        return accountId;
    }
}
