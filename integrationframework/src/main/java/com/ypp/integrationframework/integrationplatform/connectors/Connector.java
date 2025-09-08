package com.ypp.integrationframework.integrationplatform.connectors;


import com.ypp.integrationframework.integrationplatform.core.ConnectorRequest;
import com.ypp.integrationframework.integrationplatform.core.ConnectorResult;
import com.ypp.integrationframework.integrationplatform.core.EventType;

public interface Connector {
    String getName(); // "salesforce", "zapier", "webhook"

    boolean getSupportEvents(EventType type);

    /**
     * push data to external system (async allowed)
     */
    ConnectorResult push(ConnectorRequest request);

    /**
     * optional: pull or sync
     */
    default ConnectorResult pull(ConnectorRequest request) {
        throw new UnsupportedOperationException("pull not supported");
    }
    ConnectorResult testConnection(ConnectorRequest request);
}
