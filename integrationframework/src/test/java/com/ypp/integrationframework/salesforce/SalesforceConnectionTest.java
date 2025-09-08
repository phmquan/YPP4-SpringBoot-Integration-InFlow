package com.ypp.integrationframework.salesforce;

import com.ypp.integrationframework.integrationplatform.salesforce.connection.SalesforceConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesforceConnectionTest {
    @Autowired
    private SalesforceConnection connection;

    @Test
    void testConnectToSalesforce() {
        assertTrue(connection.connect());
        assertNotNull(connection.getAccessToken());
        assertNotNull(connection.getInstanceUrl());
    }
}

