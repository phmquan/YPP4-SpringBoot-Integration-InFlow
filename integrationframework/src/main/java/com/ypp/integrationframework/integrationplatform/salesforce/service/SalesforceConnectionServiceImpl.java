package com.ypp.integrationframework.integrationplatform.salesforce.service;

import com.ypp.integrationframework.integrationplatform.salesforce.connection.SalesforceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SalesforceConnectionServiceImpl implements SalesforceConnectionService {

    private final SalesforceConnection salesforceConnection;

    public SalesforceConnectionServiceImpl(SalesforceConnection salesforceConnection) {
        this.salesforceConnection = salesforceConnection;
    }

    @Override
    public ResponseEntity<String> getAccessToken() {
        boolean success = salesforceConnection.connect();
        if (success) {
            return ResponseEntity.ok("accessToken: " + salesforceConnection.getAccessToken());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
