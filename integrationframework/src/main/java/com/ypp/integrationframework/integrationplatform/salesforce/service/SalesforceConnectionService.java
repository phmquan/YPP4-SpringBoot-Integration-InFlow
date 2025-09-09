package com.ypp.integrationframework.integrationplatform.salesforce.service;

import org.springframework.http.ResponseEntity;

public interface SalesforceConnectionService {
    ResponseEntity<String> getAccessToken();
}
