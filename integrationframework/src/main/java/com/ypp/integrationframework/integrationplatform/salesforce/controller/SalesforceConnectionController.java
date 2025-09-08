package com.ypp.integrationframework.integrationplatform.salesforce.controller;

import com.ypp.integrationframework.integrationplatform.salesforce.service.SalesforceConnectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integration/salesforce")
public class SalesforceConnectionController {
    private final SalesforceConnectionService salesforceConnectionService;

    public SalesforceConnectionController(SalesforceConnectionService salesforceConnectionService) {
        this.salesforceConnectionService = salesforceConnectionService;
    }

    @GetMapping("/connect")
    public ResponseEntity<String> connect() {
        return salesforceConnectionService.getAccessToken();
    }

}
