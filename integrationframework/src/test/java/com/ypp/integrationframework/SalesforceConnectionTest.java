package com.ypp.integrationframework;

import com.ypp.integrationframework.integrationplatform.salesforce.connection.SalesforceConnection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalesforceConnectionTest {

    @Test
    void testConnectToSalesforce() {
        String clientId = "3MVG9dAEux2v1sLuy18oP4.QCvZ5Shk5.GVEMJ04caU0x16YmvAO8.9sJSOyr5I.KJSNmVWW_ftfcXcFOheIM";
        String clientSecret = "1960554EBA64A9CE2E1A35885755AF24E22F84B5E239D9834471A3F08333DF8A";
        String authUrl = "https://orgfarm-09252f5aa7-dev-ed.develop.my.salesforce.com/services/oauth2/token";

        SalesforceConnection connection = new SalesforceConnection(clientId, clientSecret, authUrl);

        assertTrue(connection.connect());
        assertNotNull(connection.getAccessToken());
        assertNotNull(connection.getInstanceUrl());
    }
}
