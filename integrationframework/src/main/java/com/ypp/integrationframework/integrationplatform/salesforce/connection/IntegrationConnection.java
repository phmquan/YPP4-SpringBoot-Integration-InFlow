package com.ypp.integrationframework.integrationplatform.salesforce.connection;

public interface IntegrationConnection {
    boolean connect();
    boolean validate();
    String getAccessToken();
}
