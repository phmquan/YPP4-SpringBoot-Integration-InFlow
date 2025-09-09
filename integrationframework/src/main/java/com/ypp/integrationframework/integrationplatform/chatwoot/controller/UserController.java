package com.ypp.integrationframework.integrationplatform.chatwoot.controller;

import com.ypp.integrationframework.integrationplatform.chatwoot.dto.UserDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integration/chatwoot")
public class UserController {
    private final ChatwootUserService chatwootUserService;

    @Autowired
    public UserController(ChatwootUserService chatwootUserService) {
        this.chatwootUserService = chatwootUserService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile() {
        return ResponseEntity.ok(chatwootUserService.getUserProfile());
    }
}