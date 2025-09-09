package com.ypp.integrationframework.integrationplatform.chatwoot.service.impl;

import com.ypp.integrationframework.integrationplatform.chatwoot.config.ChatwootConfig;
import com.ypp.integrationframework.integrationplatform.chatwoot.dto.UserDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatwootUserServiceImpl implements ChatwootUserService {
    private final ChatwootConfig chatwootConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public ChatwootUserServiceImpl(ChatwootConfig chatwootConfig) {
        this.chatwootConfig = chatwootConfig;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public UserDto getUserProfile() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api_access_token", chatwootConfig.getAccessToken());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        String url = chatwootConfig.getBaseUrl() + "/profile";

        ResponseEntity<UserDto> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, UserDto.class);

        return response.getBody();
    }
}
