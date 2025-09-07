package com.ypp.integrationframework.integrationplatform.salesforce.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SalesforceConnectionService {
    ResponseEntity<String> getAccessToken();
}
